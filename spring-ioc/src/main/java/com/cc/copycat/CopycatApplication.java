package com.cc.copycat;

import com.cc.copycat.dao.UserDao;
import com.cc.copycat.dao.UserDaoImpl;
import com.cc.copycat.service.UserService;

import java.lang.reflect.Constructor;

/**
 * @ClassName RunApplication
 * @Description
 * @Author hyl
 * @Date 02/17/2020 12:07
 **/
public class CopycatApplication {

    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.find();

        UserService service = (UserService) new MyBeanFactory("springCopycat.xml").getBean("service");
        service.find();

        /**
         * 使用Class生成对象的方法
         * 1、clazz.newInstance() 无参构造方法
         * 2、clazz.getConstructor().newInstance() 无参或有参构造方法
         */
        Class clazz = UserDaoImpl.class;
        try {
            UserDao dao = (UserDao) clazz.newInstance();
            Constructor constructor = clazz.getConstructor();
            UserDao dao2 = (UserDao) constructor.newInstance();
            System.out.println(dao);
            System.out.println(dao2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
