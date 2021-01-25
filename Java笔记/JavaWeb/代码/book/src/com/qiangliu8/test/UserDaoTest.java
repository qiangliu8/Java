package com.qiangliu8.test;

import com.qiangliu8.dao.UserDao;
import com.qiangliu8.dao.impl.UserDaoImpl;
import com.qiangliu8.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUsername("刘强")!=null){
            System.out.println("用户名存在");
        }else {
            System.out.println("用户名未注册");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsernameAndPassword("刘强","Lq0605228")!=null){
            System.out.println("查询成功");
        }else {
            System.out.println("用户名密码错误，登录失败");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.saveUser(new User(null,"俞文竹","Lq060528","1102644615@qq.com"))==1){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }
    }
}