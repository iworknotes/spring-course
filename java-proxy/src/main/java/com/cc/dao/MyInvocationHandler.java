package com.cc.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yl.huang
 * @date 2020-01-31 22:27
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----InvocationHandler Proxy before Biz-----");
        Object invoke = method.invoke(object, args);
        System.out.println("-----InvocationHandler Proxy after Biz-----");
        return invoke;
    }
}
