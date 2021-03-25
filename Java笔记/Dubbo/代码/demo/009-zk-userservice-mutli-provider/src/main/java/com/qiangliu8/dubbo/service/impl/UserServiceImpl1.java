package com.qiangliu8.dubbo.service.impl;

import com.qiangliu8.dubbo.model.User;
import com.qiangliu8.dubbo.service.UserService;

public class UserServiceImpl1 implements UserService {
    @Override
    public User queryUserById(Integer id) {
        User user = new User(id,"我的心1");
        return  user;
    }
}
