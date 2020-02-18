package com.cc.copycat;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName MyBeanFactory
 * @Description
 * @Author hyl
 * @Date 02/17/2020 21:58
 **/
public class MyBeanFactory {

    Map<String, Object> map = new HashMap<>(16);

    public MyBeanFactory(String xml) {
        parseXML(xml);
    }

    public void parseXML(String xml) {
        File file = new File(this.getClass().getResource("/").getPath() + File.separator + xml);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element root = document.getRootElement();
            Attribute rootAttribute = root.attribute("default-autowire");
            for (Iterator<Element> it = root.elementIterator(); it.hasNext(); ) {
                /**
                 * 实例化对象
                 */
                Element childFirst = it.next();
                Attribute attributeId = childFirst.attribute("id");
                String beanName = attributeId.getValue();
                Attribute attributeClazz = childFirst.attribute("class");
                String clazzName = attributeClazz.getValue();
                Class clazz = Class.forName(clazzName);
                Object object = null;

                /**
                 * 应该先把所有的bean都加载到map中,否则会因为先后顺序问题有些bean在map中找不到
                 */
                if (rootAttribute.equals("byType")) {
                    // 实例化XML中的Bean对象
                    object = clazz.newInstance();
                    // 获取Bean对象中所有的属性
                    Field[] fields = clazz.getFields();

                    // 遍历属性，然后和map中存储的bean对比，如果找到，将属性赋值
                    for (Field field : fields) {
                        int count = 0;
                        Object target = null;
                        // 获取属性的类型
                        Class fieldClazz = field.getType();
                        for (String key : map.keySet()) {
                            Object tmp = map.get(key);
                            if (tmp.getClass().getName().equals(fieldClazz.getName())) {
                                target = tmp;
                                count++;
                            }
                        }
                        if (count > 1) {
                            throw new Exception("找到两个相同类型的Bean");
                        }
                        if (target != null) {
                            field.setAccessible(true);
                            field.set(object, target);
                        }
                    }
                } else {
                    /**
                     * 维护依赖关系(看这个对象有没有依赖，判断是否有property属性)
                     */
                    for (Iterator<Element> itSecond = childFirst.elementIterator(); itSecond.hasNext(); ) {
                        Element childSecond = itSecond.next();
                        /**
                         * 1、得到ref的value，通过value得到对象(map)
                         * 2、得到name的值，然后根据值获取一个Filed的对象
                         * 3、通过field的set方法set那个对象
                         */
                        if (childSecond.getName().equals("property")) {
                            object = clazz.newInstance();
                            // 获取到注入对象
                            String refValue = childSecond.attribute("ref").getValue();
                            Object injetObject = map.get(refValue);

                            String nameValue = childSecond.attribute("name").getValue();
                            Field field = clazz.getDeclaredField(nameValue);
                            // 设置私有方法可以访问
                            field.setAccessible(true);
                            // 通过field对象的set方法，设置所在对象中的值
                            field.set(object, injetObject);
                        } else if (childSecond.getName().equals("constructor-arg")) {
                            String refValue = childSecond.attribute("ref").getValue();
                            Object injetObject = map.get(refValue);
                            Constructor constructor = clazz.getConstructor(injetObject.getClass().getInterfaces());
                            object = constructor.newInstance(injetObject);
                        }
                    }

                    if (object == null) {
                        object = clazz.newInstance();
                    }
                }
                map.put(beanName, object);
            }
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beanName) {
        return map.get(beanName);
    }

}
