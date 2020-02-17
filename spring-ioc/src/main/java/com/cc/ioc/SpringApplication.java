package com.cc.ioc;

import com.cc.ioc.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yl.huang
 * @date 2020-01-29 11:32
 */
public class SpringApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.findAll();
    }

}
