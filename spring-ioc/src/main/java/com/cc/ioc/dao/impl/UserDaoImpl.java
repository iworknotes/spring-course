package com.cc.ioc.dao.impl;

import com.cc.ioc.dao.UserDao;
import com.cc.ioc.model.User;

/**
 * @author yl.huang
 * @date 2020-01-29 11:44
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User select() {
        System.out.println("do select.....");
        return null;
    }
}
