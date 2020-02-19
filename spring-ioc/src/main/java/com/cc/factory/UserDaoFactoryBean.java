package com.cc.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDaoFactoryBean
 * @Description
 * @Author hyl
 * @Date 02/19/2020 14:55
 **/
@Component("userDaoFactoryBean")
public class UserDaoFactoryBean implements FactoryBean {

    public void test() {
        System.out.println("UserDaoFactoryBean test");
    }

    @Override
    public Object getObject() throws Exception {
        return new UserDao();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }
}
