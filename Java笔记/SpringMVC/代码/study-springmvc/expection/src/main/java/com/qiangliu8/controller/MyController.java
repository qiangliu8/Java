package com.qiangliu8.controller;


import com.qiangliu8.exception.AgeException;
import com.qiangliu8.exception.MyUserException;
import com.qiangliu8.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/some.do")
    public ModelAndView doSome(String name,Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();

        //根据请求参数抛出异常
        if (!"zs".equals(name)){
            throw new NameException("姓名不正确！");
        }
        if (age==null||age<0){
            throw new AgeException("性别错误！");
        }

        mv.addObject("name",name);
        mv.addObject("age",age);
        //显示转发
        mv.setViewName("forward:/WEB-INF/jsp/show.jsp");

        return mv;
    }

}
