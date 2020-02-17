package com.cc.ioc.service;

import com.cc.ioc.model.User;

import java.util.List;

/**
 * @author yl.huang
 * @date 2020-01-29 11:34
 */
public interface UserService {

    List<User> findAll();

    User findOne(Long id);

}
