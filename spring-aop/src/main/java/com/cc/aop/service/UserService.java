package com.cc.aop.service;

import com.cc.aop.Course;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author yl.huang
 * @date 2020-01-29 15:30
 */
@Service("userService")
@Scope("prototype")
public class UserService implements IUserService{

    @Course
    @Override
    public void query() {
        System.out.println("do query.....");
    }

}
