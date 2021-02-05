package com.qiangliu8.demo.aopanno;

import org.springframework.stereotype.Component;

//被增强类
@Component
public class User {
    //被增强方法
    public void add(){
        System.out.println("User..add.");
    }
}
