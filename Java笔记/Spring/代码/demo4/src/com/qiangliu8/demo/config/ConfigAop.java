package com.qiangliu8.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.qiangliu8.demo"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
