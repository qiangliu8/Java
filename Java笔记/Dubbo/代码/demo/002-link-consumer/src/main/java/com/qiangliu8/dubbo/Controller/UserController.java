package com.qiangliu8.dubbo.Controller;

import com.qiangliu8.dubbo.model.User;
import com.qiangliu8.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String userDetail(Model model, Integer id){
        User user = userService.queryUserById(id);
        model.addAttribute("user",user);
        return "userDetail";
    }
}
