package com.qiangliu8.service;

import com.qiangliu8.dao.UserDao;
import com.qiangliu8.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao bookDao;



    //添加方法
    public void addUser(User user){
        bookDao.addUser(user);
    }

    //修改方法
    public void updateUser(User user){
        bookDao.updateUser(user);
    }

    //删除方法
    public void deleteUser(String id){
        bookDao.deleteUser(id);
    }
    //查询表记录数
    public int findCount(){
        int count = bookDao.selectCount();
        return count;
    }

    //查询详细记录
    public User findUserInfo(String id){
        return bookDao.findUserInfo(id);
    }


    //查询记录集合
    public List<User> findUserAllList(){
        return bookDao.findUserAllList();
    }

    //批量添加
    public void  batchAdd(List<Object[]> batchArgs){
        bookDao.batchAdd(batchArgs);
    }
    //批量修改
    public void  batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }

    //批量删除
    public void  batchDelete(List<Object[]> batchArgs){
        bookDao.batchDelete(batchArgs);
    }
}
