package com.cc.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yl.huang
 * @date 2020-01-29 15:27
 */
@Configuration
@ComponentScan({"com.cc.aop"})
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class SpringConfig {
}
