package com.qiangliu8.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiangliu8.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller

public class MyController {

//    处理器方法返回String 表示逻辑视图名称 需要配置视图解析器
    @RequestMapping("/returnString.do")
    public String returnString(Student student,HttpServletRequest request){

        //可以自己手工添加数据到request作用域
        request.setAttribute("name",student.getName());
        request.setAttribute("age",student.getAge());
        //show:逻辑视图名称，项目中配置了视图解析器
        //框架对视图直送forward转发操作
        return "show";
    }

//处理器方法返回String,表示完整视图路径，此时不能配置视图解析器
@RequestMapping("/returnString2.do")
public String returnString2(Student student,HttpServletRequest request){

    //可以自己手工添加数据到request作用域
    request.setAttribute("name",student.getName());
    request.setAttribute("age",student.getAge());
    //完整视图路径，项目中配置了视图解析器
    //框架对视图直送forward转发操作
    return "WEB-INF/view/show.jsp";
    //报错 文.件[/WEB-INF/view/WEB-INF/view/show.jsp.jsp] 未找到
}


    //处理器方法返回String,表示完整视图路径，此时不能配置视图解析器
    @RequestMapping("/returnVoid.do")
    public void returnVoid(Student student,HttpServletResponse response) throws IOException {
        //处理ajax,使用json做数据的格式 把结果的对象转为json格式的数据
            String json = "";
            if (student!=null){
                ObjectMapper objectMapper = new ObjectMapper();
                json = objectMapper.writeValueAsString(student);
                System.out.println("json："+json);
            }
        //输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(json);
        printWriter.flush();
        printWriter.close();
    }


//    处理器方法返回一个Student，通过框架转为json,响应ajax请求
    @RequestMapping(value = "returnVoid2.do")
    @ResponseBody
    public Student returnObject(Student student){

        return student;
    }


    // 处理器返回List<Student>
    @RequestMapping(value = "returnVoid3.do")
    @ResponseBody
    public List<Student> returnObject3(Student student){
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student);
        studentList.add(student);
        return studentList;
    }

// 处理器参会String ,String表示数据的,不是视图
//        区分返回值Strin是数据还是视图,看有没有@Responsebody注解
//        如果有@Responsebody注解,返回String就是数据,反之就是视图
//    默认使用text/plain;charset=ISO-8859-1作为ContentType,导致中文有乱码
//    给RequestMapping增加一个属性produces,使用这个刷新指定新的contentType
    @RequestMapping(value = "returnVoid4.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String returnString2(Student student){
        return "处理器参会String ,String表示数据的,不是视图";
    }
}
