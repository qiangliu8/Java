package com.qiangliu8.springboot.Controller;

import com.qiangliu8.springboot.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class UserController {

    @RequestMapping("/eachList")
    public String eachList(Model model){
        List<User> users = new ArrayList<User>();
        for (int i = 0 ;i<10;i++){
            users.add(new User(i,i+"号","1575533716"+i,"合肥市"+i));
        }
        model.addAttribute("userList",users);
        return "eachList";
    }

    @RequestMapping("/eachMap")
    public String eachMap(Model model){
        Map<Integer,User> userMap = new HashMap<>();
        for (int i = 0 ;i<10;i++){
            userMap.put(i,new User(i,i+"号","1575533716"+i,"合肥市"+i));
        }
        model.addAttribute("userMap",userMap);
        return "eachMap";
    }

    @RequestMapping("/eachArray")
    public String eachArray(Model model){
        User[] userArrayList = new User[10];
        for (int i = 0 ;i<10;i++){
            userArrayList[i] = new User(i,i+"号","1575533716"+i,"合肥市"+i);
        }
        model.addAttribute("eachArray",userArrayList);
        return "eachAr ray";
    }

    @RequestMapping("/condition")
    public String condition(Model model){
        model.addAttribute("sex",1);
        model.addAttribute("flag",true);
        model.addAttribute("productType",0);
        return "condition";
    }

    @RequestMapping("/inline-text")
    public String inline_text(Model model){
        model.addAttribute("data","springboot_inline");
        return "inline-text";
    }
    @RequestMapping("/literal")
    public String literal(Model model){
        model.addAttribute("sex","man");
        model.addAttribute("data","sringbootdata");
        model.addAttribute("flag",true);

        model.addAttribute("user",new User(1001,"刘强","157",null));
        return "literal";
    }

    @RequestMapping("/expression")
    public String expression(HttpServletRequest httpServletRequest,Model model){
        model.addAttribute("username","刘强");
        httpServletRequest.getSession().setAttribute("address","合肥");
        httpServletRequest.getSession().setAttribute("data","我爱合肥");

        return "expression";
    }
    @RequestMapping("/function")
    public String function(Model model){
        model.addAttribute("username","刘强");
        model.addAttribute("time",new Date());
        return "function";
    }
}
