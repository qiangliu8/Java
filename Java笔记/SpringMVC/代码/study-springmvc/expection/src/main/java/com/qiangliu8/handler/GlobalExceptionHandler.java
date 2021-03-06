package com.qiangliu8.handler;


import com.qiangliu8.exception.AgeException;
import com.qiangliu8.exception.NameException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/*
* @ControllerAdvice：控制器增强，也就是控制器类增加功能--异常处理功能
* 特点：必须让框架知道这个注解所在的包名，需要再springmcv配置文件声明组件扫描器
* 指定@ControllerAdvice所在的包名
* */
@ControllerAdvice
public class GlobalExceptionHandler {
    //定义方法，处理发生的异常
    /*
    * 处理异常的方法和控制器方法一样，可有有多个参数，可以有ModelAndView
    * String,void 对象类型的返回值
    * 形参：EXception 表示Controller中抛出的异常对象
    * 通过形参可以获取发生的异常信息
    * */
    /*@ExceptionHander(异常的class) 表示异常的类型，当发生此类型异常时，由当前方法处理
    * */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
        //处理NameException的异常
        /*异常发生处理逻辑
        * 1.需要把异常记录下来，记录到数据库，日志文件
        * 记录日志发生的时间，哪个方法发生的，异常错误内容
        * 2.发送通过，把异常的信息通过邮件发送给相关人员
        * 3.给用户友好提示
        * */

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","姓名必须是张三，其它不能访问");
        modelAndView.addObject("exception",exception);
        modelAndView.setViewName("nameError");
        return modelAndView;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","年龄不能小于0 也不能为空");
        modelAndView.addObject("exception",exception);
        modelAndView.setViewName("ageError");
        return modelAndView;
    }
    //处理其他异常，上面两个以外的异常  只能由一个这样的方法
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","其他异常");
        modelAndView.addObject("exception",exception);
        modelAndView.setViewName("otherError");
        return modelAndView;
    }

}
