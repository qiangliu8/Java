package com.qiangliu8.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication//开启扫描spring
@ServletComponentScan(basePackages = "com.qiangliu8.springboot.servlet")
//@ServletComponentScan(basePackages = "com.qiangliu8.springboot.filter")
public class ServletApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        //参数为当前Springboot启动类
//        //构建新资源
//        return builder.sources(ServletApplication.class);
//    }
}
