package com.qiangliu8.dubbo.controller;

import com.qiangliu8.dubbo.model.User;
import com.qiangliu8.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService1;
    @Autowired
    private UserService userService2;

    @RequestMapping("/user")
    public ModelAndView getUser(){
        ModelAndView modelAndView = new ModelAndView();
        User user1 = userService1.queryUserById(1);
        User user2 = userService2.queryUserById(2);
        modelAndView.addObject("user1",user1);
        modelAndView.addObject("user2",user2);
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
