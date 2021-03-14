package com.qiangliu8.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping(value = "/some.do")
    @ResponseBody
    public ModelAndView doSome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","厉害了！");
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
