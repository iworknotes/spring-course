package com.cc.ioc.dao.impl;

import com.cc.ioc.dao.UserDao;
import com.cc.ioc.model.User;

/**
 * @ClassName UserDaoImpl2
 * @Description
 * @Author hyl
 * @Date 02/18/2020 14:24
 **/
public class UserDaoImpl2 implements UserDao {
    @Override
    public User select() {
        System.out.println("do select2.....");
        return null;
    }
}
