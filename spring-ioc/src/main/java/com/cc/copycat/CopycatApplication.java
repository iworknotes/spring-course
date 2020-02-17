package com.cc.copycat;

import com.cc.copycat.service.UserService;

/**
 * @ClassName RunApplication
 * @Description
 * @Author hyl
 * @Date 02/17/2020 12:07
 **/
public class CopycatApplication {

    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.find();

        UserService service = (UserService) new MyBeanFactory("springCopycat.xml").getBean("service");
        service.find();
    }

}
