package com.cc.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yl.huang
 * @date 2020-02-01 00:00
 */
public class DemoApplication {

    public static void main(String[] args) {
//        final Person student = new Student();
//        InvocationHandler handler = new MyInvocationHandler(student);
//        Person studentProxy = (Person) Proxy.newProxyInstance(
//                handler.getClass().getClassLoader(),
//                student.getClass().getInterfaces(),
//                handler);
//        studentProxy.work();

        final Person student = new Student();
        Person studentProxy = (Person) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{Person.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("--- JDK动态代理 ---");
                        return method.invoke(student, args);
                    }
                });
        studentProxy.work();
    }

}
