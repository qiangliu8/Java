package com.qiangliu8.controller;

import com.qiangliu8.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@RequestMapping：
//value :所有请求地址的公共部分，叫做模块名称
//位置放在类的上面

//Controller创建处理器对象，对象放在springmvc容器中
@Controller
@RequestMapping("/test")
public class MyController {
    //处理用户提交的请求，springmvc中是使用方法来处理的
    //方法是自定义的，可以有多种返回值，多种参数，方法名称自定义


//    准备使用doSome方法处理some.do请求
//    @RequestMapping 请求映射，作用是把一个请求地址和一个方法绑定在一起
//        一个请求指定一个方法
//        属性: value是一个String，表示请求的url地址 值必须是唯一值，不能重复。
//          位置：在方法的上面。在类的上面
//        使用@RequestMapping修饰的方法可以处理请求的，类似Servlet中的doGet，doPost
//        返回值 ：ModelAndView = Model+View 数据加试图
//        属性:method 表示请求的方法。它的值RequestMethod类枚举值 例如RequestMethod.GET

    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView  doSome(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        System.out.println("这是doSome的请求");

        ModelAndView modelAndView = new ModelAndView();
        //添加数据，框架在请求的最后把数据方法request作用域中
        //request.setAttribute("msg","欢迎使用mvc");
        modelAndView.addObject("msg","欢迎使用mvc");
        modelAndView.addObject("fun","执行doSome方法");
        //指定试听与，指定试图的完整路径
        //框架对试图执行的forword操作，reqyest.getRequestDispatcher(”/show.jsp").forward(...)

//        modelAndView.setViewName("/show.jsp");
//       modelAndView.setViewName("/WEB-INF/view/show.jsp");
//        modelAndView.setViewName("/WEB-INF/view/other.jsp");

//        当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
//        框架会使用视图解析器的前缀+逻辑名称+后缀 组成全程路径，这里就是字符连接操作
        modelAndView.setViewName("show");

        return modelAndView;
    }

    @RequestMapping(value ={"/other.do"} ,method=RequestMethod.POST)
    public ModelAndView  doOther(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpSession httpSession){
        System.out.println("这是doOther的请求");

        ModelAndView modelAndView = new ModelAndView();
        //添加数据，框架在请求的最后把数据方法request作用域中
        //request.setAttribute("msg","欢迎使用mvc");
        modelAndView.addObject("msg","欢迎使用mvc");
        modelAndView.addObject("fun","执行doOther方法");
        System.out.println(httpServletRequest.getParameter("name"));
        modelAndView.setViewName("other");
        return modelAndView;
    }

//    逐个接收请求参数
//        要求：处理器方法的形参名和请求中参数名必须一致。
//            同名的请求参数赋值给同名的形参
//        框架接受请求参数
//        1.使用request对象接受请求参数
//            String  strName = request.getParameter("name");
//            String  strAge = request.getParameter("age");
//        2.springmvc框架通过DispatcherServlet 调用MyController的doSome()方法
//            调用方法时，按名称对应，把接受的参数赋值给形参
//            doSome（strName,Interger,valueOf(strage)）
//            框架会提供类型转换的功能，能把String转换成int,long,float等类型
//
//    400状态码是客户端错误，表示提交请求参数过程中，发生了问题。

    @RequestMapping(value ={"/receiveproperties.do"} ,method=RequestMethod.POST)
    public ModelAndView  receiveProperties(String name,Integer age){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name",name);
        modelAndView.addObject("age",age);
        System.out.println(name);
        modelAndView.setViewName("other");
        return modelAndView;
    }

//    请求中参数名和处理器方法的形参名不一样
//    @RequestParam:解决请求中参数名形参名不一样的问题
//    属性:1.value请求中的参数名称
//      2.required 是一个boolean 默认时true
//      true表示请求中必须包含此参数
//    位置:在处理器方法的形参定义的前面

    @RequestMapping(value ={"/receiveparam.do"} )
    public ModelAndView  receiveParam(@RequestParam(value = "pname",required = false) String name, @RequestParam(value = "page",required = false) Integer age){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name",name);
        modelAndView.addObject("age",age);
        System.out.println(name);
        modelAndView.setViewName("other");
        return modelAndView;
    }

//    处理器方法形参是Java对象 这个对象的属性名和请求中的参数名一样的
//    框架会创建形参的Java对象，给属性赋值。请求中的参数是name,框架会调用setName()
    @RequestMapping(value ={"/receiveobject.do"} )
    public ModelAndView  receiveObject(Student student){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name",student.getName());
        modelAndView.addObject("age",student.getAge());
        modelAndView.setViewName("other");
        return modelAndView;
    }
}
