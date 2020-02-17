package com.cc.ioc.service.impl;

import com.cc.ioc.dao.UserDao;
import com.cc.ioc.model.User;
import com.cc.ioc.service.UserService;

import java.util.List;

/**
 * @author yl.huang
 * @date 2020-01-29 11:35
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        System.out.println("do find all...");
        userDao.select();
        return null;
    }

    @Override
    public User findOne(Long id) {
        System.out.println("do find one...");
        return null;
    }

}
