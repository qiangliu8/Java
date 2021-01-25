package com.qiangliu8.test;

import com.qiangliu8.pojo.User;
import com.qiangliu8.service.UserService;
import com.qiangliu8.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"吴云","123456","123456@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"刘强","Lq060528","1102644615@qq.com")));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("俞文竹")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}