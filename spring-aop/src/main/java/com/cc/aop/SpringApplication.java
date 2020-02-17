package com.cc.aop;

import com.cc.aop.service.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yl.huang
 * @date 2020-01-29 15:27
 */
public class SpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IUserService service = (IUserService) context.getBean("userService");
        service.query();
        IUserService service2 = (IUserService) context.getBean("userService");
        service2.query();
        System.out.println(service.hashCode() + " || " + service2.hashCode());

//        OrderService service = (OrderService) context.getBean("orderService");
//        service.find();
//        OrderService service2 = (OrderService) context.getBean("orderService");
//        service2.find();
//        System.out.println(service.hashCode() + " || " + service2.hashCode());
    }

}
