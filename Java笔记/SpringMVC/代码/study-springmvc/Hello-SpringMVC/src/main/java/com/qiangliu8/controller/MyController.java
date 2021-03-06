package com.qiangliu8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controller创建处理器对象，对象放在springmvc容器中
@Controller
public class MyController {
    //处理用户提交的请求，springmvc中是使用方法来处理的
    //方法是自定义的，可以有多种返回值，多种参数，方法名称自定义


//    准备使用doSome方法处理some.do请求
//    @RequestMapping 请求映射，作用是把一个请求地址和一个方法绑定在一起
//        一个请求指定一个方法
//        属性: value是一个String，表示请求的url地址 值必须是唯一值，不能重复。
//        位置：在方法的上面。在类的上面
//        使用@RequestMapping修饰的方法可以处理请求的，类似Servlet中的doGet，doPost
//        返回值 ：ModelAndView = Model+View 数据加试图

    @RequestMapping(value = "/some.do")
    public ModelAndView  doSome(){
        System.out.println("这是doSome的请求");

        ModelAndView modelAndView = new ModelAndView();
        //添加数据，框架在请求的最后把数据方法request作用域中
        //request.setAttribute("msg","欢迎使用mvc");
        modelAndView.addObject("msg","欢迎使用mvc");
        modelAndView.addObject("fun","执行doSome方法");
        //指定试听与，指定试图的完整路径
        //框架对试图执行的forword操作，reqyest.getRequestDispatcher(”/show.jsp").forward(...)

//        modelAndView.setViewName("/show.jsp");
//        modelAndView.setViewName("/WEB-INF/view/show.jsp");
//        modelAndView.setViewName("/WEB-INF/view/other.jsp");

//        当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
//        框架会使用视图解析器的前缀+逻辑名称+后缀 组成全程路径，这里就是字符连接操作
        modelAndView.setViewName("show");

        return modelAndView;
    }
}
