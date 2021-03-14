package com.qiangiu8.springboot.controller;

import com.qiangiu8.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/login")
    public Object login(HttpServletRequest request){
        //将用户信息存入session中
        request.getSession().setAttribute("user",new User(1001,"刘强"));
        return  "login success";
    }

    @RequestMapping(value = "/center")
    public Object center(HttpServletRequest request){
        return "see center";
    }

    @RequestMapping(value = "/out")
    public Object out(HttpServletRequest request){
        return "see out";
    }
    @RequestMapping(value = "/error")
    public Object error(HttpServletRequest request){
        return "see error";
    }
}
