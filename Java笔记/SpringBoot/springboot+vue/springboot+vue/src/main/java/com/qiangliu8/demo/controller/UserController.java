package com.qiangliu8.demo.controller;

import com.qiangliu8.demo.bean.QueryInfo;
import com.qiangliu8.demo.bean.User;
import com.qiangliu8.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/getUserById")
    public Object getUserById(int id){
        boolean flag = false;
        Map<String,Object> map = new HashMap<>();
        User user1 = userDao.getUserById(id);
        if (user1 != null){
            flag = true;
        }
        System.out.println(user1);
        map.put("flag",flag);
        map.put("user",user1);
        return  map;
    }

    //获取所有用户列表
    @RequestMapping(value = "/getUserList")
    public Object getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        //获取用户个数
        int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%");

        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> userList = userDao.getUserList("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());

        Map<String,Object> map = new HashMap<>();
        int status = 404 ;
        if (userList!=null){
            map.put("status",200);
            map.put("data",userList);
            map.put("num",numbers);
        }
        return map;
    }
    //修改用户状态
    @RequestMapping(value = "/updateUserState")
    public String updateUserState(@RequestParam("id") Integer id,@RequestParam("state") Boolean state){
        int i = userDao.updateState(id,state);
        return i > 0 ?"success":"error";
    }
    //添加用户
    @RequestMapping(value = "/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        return i > 0 ?"success":"error";
    }
    //删除用户
    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id")  int id){
        int i = userDao.deleteUser(id);
        return i > 0 ?"success":"error";
    }
    //更改用户
    @RequestMapping(value = "/updateUser")
    public String updateUser(@RequestBody User user){
        int i = userDao.updateUser(user);
        return i > 0 ?"success":"error";
    }
}

