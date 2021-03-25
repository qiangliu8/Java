package com.qiangliu8.dubbo.impl;

import com.qiangliu8.dubbo.model.User;
import com.qiangliu8.dubbo.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User queryUserById(Integer id) {
        User user = new User(id,"我的爱");
        return  user;
    }
}
