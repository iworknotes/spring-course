package com.cc.proxy;

import com.cc.dao.UserDaoImpl;

/**
 * 静态代理:继承
 *
 * @author yl.huang
 * @date 2020-01-30 22:31
 */
public class UserDaoImplProxy extends UserDaoImpl {

    @Override
    public void query() {
        System.out.println("-----静态代理,继承-----");
        super.query();
    }
}
