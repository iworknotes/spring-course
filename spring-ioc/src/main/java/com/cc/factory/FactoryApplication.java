package com.cc.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName FactoryApplication
 * @Description
 * @Author hyl
 * @Date 02/19/2020 14:57
 **/
public class FactoryApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDaoFactoryBean userDaoFactoryBean = (UserDaoFactoryBean) context.getBean("&userDaoFactoryBean");
        userDaoFactoryBean.test();

        UserDao userDao = (UserDao) context.getBean("userDaoFactoryBean");
        userDao.test();

        context.register(SpringConfig.class);
        context.register(UserDao.class);
        context.scan("com.cc.factory");
        context.refresh();

    }

}
