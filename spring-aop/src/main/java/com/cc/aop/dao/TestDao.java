package com.cc.aop.dao;

import org.springframework.stereotype.Repository;

/**
 * @author yl.huang
 * @date 2020-01-29 23:40
 */
@Repository("testDao")
public class TestDao {

    public void select(){
        System.out.println("test dao doing select");
    }

}
