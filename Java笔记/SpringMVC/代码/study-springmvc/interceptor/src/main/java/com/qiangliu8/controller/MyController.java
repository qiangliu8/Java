package com.qiangliu8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/some.do")
    public ModelAndView doSome(String name,Integer age){
        System.out.println("====执行Controller中的doSome方法====");
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }
}
