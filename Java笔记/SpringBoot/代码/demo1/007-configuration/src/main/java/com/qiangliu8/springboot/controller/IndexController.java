package com.qiangliu8.springboot.controller;

import com.qiangliu8.springboot.config.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private School school;

    @Value("${his.name}")
    private String name;

    @RequestMapping(value = "/say")
    @ResponseBody
    public String say(){
        return "你好,"+name;
    }

    @RequestMapping(value = "/mapValue")
    @ResponseBody
    public Map<String,Object> mapValue(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","刘强");
        return map;
    }

    @RequestMapping("/school")
    @ResponseBody
    public String getSchool(){
        return "学校名称："+school.getName()+"，办学时间："+school.getAge();
    }

    @RequestMapping("/doSome")
    @ResponseBody
    public ModelAndView doSome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","这是show页面");
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
