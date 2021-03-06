package com.qiangliu8.controller;

import com.qiangliu8.domain.Student;
import com.qiangliu8.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyController {

    //    处理器方法返回ModeLAndview,实现forward
    //redirect特点:不和视图解析器一同使用，就当项目中没有视图解析器
    @RequestMapping("/doForward.do")
    public ModelAndView doForward(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc");
        mv.addObject("fun","doForward");
        //显示转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");

        //mv.setViewName("forward:/other.jsp");
        return mv;
    }

//    处理器方法返回ModeLAndview,实现重定向redirect
//    redirect特点:不和视图解析器一同使用，就当项目中没有视图解析器
//        框架对重定向的操作：
//    框架会把Model中的简单类型的数据，转为Strings使用，作为hello.jsp的get请求参数使用
//    目的是：可以在doRedirect.do 和hello。jsp两次请求之间传递数据
    @RequestMapping("/doRedirect.do")
    public ModelAndView doRedirect(){
        ModelAndView mv = new ModelAndView();
        //数据放入到 request作用域
        mv.addObject("msg","欢迎使用springmvc");
        mv.addObject("fun","doForward");
//        显示转发
        mv.setViewName("redirect:/show.jsp");
        //http://localhost:8080/forward_war_exploded/show.jsp?msg=%E6%AC%A2%E8%BF%8E%E4%BD%BF%E7%94%A8springmvc&fun=doForward
        return mv;
    }
}
