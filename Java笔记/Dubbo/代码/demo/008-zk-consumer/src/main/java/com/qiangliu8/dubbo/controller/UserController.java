package com.qiangliu8.dubbo.controller;

import com.qiangliu8.dubbo.model.User;
import com.qiangliu8.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public ModelAndView getUser(){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.queryUserById(1003);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
