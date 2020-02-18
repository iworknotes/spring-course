package com.cc.copycat.service;

import com.cc.copycat.dao.UserDao;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author hyl
 * @Date 02/17/2020 12:25
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void find() {
        userDao.query();
        System.out.println("service.");
    }
}
