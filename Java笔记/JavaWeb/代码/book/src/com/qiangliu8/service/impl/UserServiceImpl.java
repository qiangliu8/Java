package com.qiangliu8.service.impl;

import com.qiangliu8.dao.UserDao;
import com.qiangliu8.dao.impl.UserDaoImpl;
import com.qiangliu8.pojo.User;
import com.qiangliu8.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    public UserServiceImpl() {

    }

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            //null则没查到
            return false;
        }
        return true;
    }
}
