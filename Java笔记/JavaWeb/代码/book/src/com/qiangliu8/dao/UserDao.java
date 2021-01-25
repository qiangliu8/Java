package com.qiangliu8.dao;

import com.qiangliu8.pojo.User;

public interface UserDao {
    //根据用户名查询用户信息
    //如果返回null说明用户未注册
    public User queryUserByUsername(String username);


    public User queryUserByUsernameAndPassword(String username,String password);

    //保存用户信息
    public int saveUser(User user);
}
