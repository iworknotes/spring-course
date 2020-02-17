package com.cc;

import com.cc.dao.IUserDao;
import com.cc.dao.MyInvocationHandler;
import com.cc.dao.UserDaoImpl;
import com.cc.proxy.UserDaoImplProxy;
import com.cc.proxy.UserDaoImplProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yl.huang
 * @date 2020-01-30 22:29
 */
public class Application {

    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImplProxy();
        userDao.query();

        IUserDao target = new UserDaoImpl();
        IUserDao proxy = new UserDaoImplProxy2(target);
        proxy.query();

        IUserDao dao = new UserDaoImpl();
        InvocationHandler handler = new MyInvocationHandler(dao);

        IUserDao daoProxy = (IUserDao) Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                dao.getClass().getInterfaces(),
                handler);
        daoProxy.query();
    }

}
