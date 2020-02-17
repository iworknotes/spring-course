package com.cc.aop.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author yl.huang
 * @date 2020-01-29 23:11
 */
@Service("orderService")
@Scope("prototype")
public class OrderService {

    public void find() {
        System.out.println("orderService do find.....");
    }

}
