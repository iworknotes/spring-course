package com.cc.test;

import com.cc.demo.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;

/**
 * @author yl.huang
 * @date 2020-02-01 13:44
 */
public class Test {

    public static void main(String[] args) {
        byte[] bytes = ProxyGenerator.generateProxyClass("ProxyPerson", new Class[]{Person.class});
        try {
            FileOutputStream out = new FileOutputStream("/Users/Binary/Downloads/ProxyPerson.class");
            try {
                out.write(bytes);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param loader     类加载器,判断对象是否是同一个,首先必须是同一个类加载器
     * @param interfaces 要代理的接口
     * @param h          InvocationHandler代理逻辑类
     * @return
     * @throws IllegalArgumentException
     */
    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h) throws IllegalArgumentException {
        return null;
    }

}
