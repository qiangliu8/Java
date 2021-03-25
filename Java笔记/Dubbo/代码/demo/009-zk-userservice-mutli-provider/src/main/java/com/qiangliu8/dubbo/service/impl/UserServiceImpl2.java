package com.qiangliu8.dubbo.service.impl;

import com.qiangliu8.dubbo.model.User;
import com.qiangliu8.dubbo.service.UserService;

public class UserServiceImpl2 implements UserService {
    @Override
    public User queryUserById(Integer id) {
        User user = new User(id,"我的心2");
        return  user;
    }
}
