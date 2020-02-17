package com.cc.proxy;

import com.cc.dao.IUserDao;

/**
 * 静态代理:聚合
 *
 * @author yl.huang
 * @date 2020-01-30 22:33
 */
public class UserDaoImplProxy2 implements IUserDao {

    private IUserDao userDao;

    public UserDaoImplProxy2(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void query() {
        System.out.println("-----静态代理,聚合-----");
        userDao.query();
    }
}
