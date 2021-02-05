package com.qiangliu8.dao;

import com.qiangliu8.entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(String id);

    int selectCount();

    User findUserInfo(String id);

    List<User> findUserAllList();

    void batchAdd(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
