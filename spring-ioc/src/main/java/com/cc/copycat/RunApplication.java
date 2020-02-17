package com.cc.copycat;

import com.cc.copycat.service.UserService;
import com.cc.copycat.service.UserServiceImpl;

/**
 * @ClassName RunApplication
 * @Description
 * @Author hyl
 * @Date 02/17/2020 12:07
 **/
public class RunApplication {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.find();
    }

}
