package com.cc.test;

import com.cc.demo.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class ProxyPerson extends Proxy implements Person {

    /**
     * InvocationHandler 对象
     *
     * @param paramInvocationHandler
     */
    public ProxyPerson(InvocationHandler paramInvocationHandler) {
        super(paramInvocationHandler);
    }

    public final void work() {
        try {
            // 调用InvocationHandler类的invoke方法
//            this.h.invoke(this, m3, null);
            return;
        } catch (Error | RuntimeException localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

}

