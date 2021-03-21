package com.qiangliu8.demo.controller;

import com.alibaba.fastjson.JSON;
import com.qiangliu8.demo.bean.User;
import com.qiangliu8.demo.dao.UserDao;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/logins")
    public String test(HttpServletRequest request, HttpServletResponse response,String username){
        System.out.println(request);
        System.out.println(username);
        return "test my test";
    }
//    @RequestMapping(value = "/login")
//    public  Object login(@RequestBody User user){
//        System.out.println("user:"+user.getUsername());
//        User user1  = userDao.getUserbyMessage(user.getUsername(),user.getPassword());
//        return user1;
//    }

    @RequestMapping(value = "/login")
    public Object login(@RequestBody User user){
        boolean flag = false;
        Map<String,Object> map = new HashMap<>();
        User user1 = userDao.getUserbyMessage(user.getUsername(),user.getPassword());
        if (user1 != null){
            flag = true;
        }
        System.out.println(user1);
        map.put("flag",flag);
        map.put("user",user1);
        return  map;
    }
}
