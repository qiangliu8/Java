package com.qiangliu8.service;

import com.qiangliu8.pojo.User;

public interface UserService {

    //注册用户
    public void registerUser(User user);

    //登录用户
    public User login(User user);

    //检查用户名是否可用
    //返回true表示用户名已存在，返回false表示用户名可用
    public boolean existUsername(String username);
}
