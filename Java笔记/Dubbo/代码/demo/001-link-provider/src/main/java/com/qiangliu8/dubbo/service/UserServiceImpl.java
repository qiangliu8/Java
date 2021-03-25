package com.qiangliu8.dubbo.service;

import com.qiangliu8.dubbo.model.User;

public class UserServiceImpl implements UserService {
    @Override
    public User queryUserById(Integer id) {
        User user = new User(id,"刘强",23);
        return user;
    }
}
