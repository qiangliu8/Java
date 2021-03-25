package com.qiangliu8.dubbo.service.impl;

import com.qiangliu8.dubbo.model.User;
import com.qiangliu8.dubbo.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User queryUserById(Integer id) {
        User user = new User(id,"俞文竹",23);
        return user;
    }

    @Override
    public Integer selectUserCounts() {
        return 55;
    }
}
