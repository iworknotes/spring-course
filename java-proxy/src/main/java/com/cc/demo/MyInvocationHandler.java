package com.cc.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yl.huang
 * @date 2020-01-31 23:58
 */
public class MyInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * @param method 目标对象方法
     * @param args   目标对象方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before.");
        Object invoke = method.invoke(target, args);
        System.out.println("proxy after.");
        return invoke;
    }
}
