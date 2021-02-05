package com.qiangliu8.service;

import com.qiangliu8.dao.UserDao;
import com.qiangliu8.dao.UserDaoImpl;

public class UserService {

    //创建UserDao属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service-add");
        userDao.update();
    }
}
