package com.cc.aop;

import com.cc.aop.service.IUserService;
import com.cc.aop.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author yl.huang
 * @date 2020-01-29 15:32
 */
@Component
@Aspect("perthis(this(com.cc.aop.service.IUserService))")
@Scope("prototype")
public class MyAspectJ {

    @DeclareParents(value = "com.cc.aop.service.*", defaultImpl = UserService.class)
    public static IUserService service;

    @Pointcut("this(com.cc.aop.service.IUserService)")
    public void pointCutThis() {

    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @throws Throwable
     */
    @Around("pointCutThis()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(this.hashCode());
        System.out.println("around before...");
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                args[i] += "扩展参数";
            }
        }
        // 继续执行连接点
        pjp.proceed(args);
        System.out.println("around after...");
    }

    @Pointcut("execution(* com.cc.aop..*.*(..))")
    public void pointCut() {

    }

    @Pointcut("within(com.cc..*)")
    public void pointCutWithin() {

    }

    @Pointcut("@annotation(com.cc.aop.Course)")
    public void pointCutAnotation() {

    }

//    @Before("pointCutThis()")
    public void before() {
        System.out.println("before...");
    }

    //    @After("pointCutThis()")
    public void after() {
        System.out.println("after...");
    }

}
