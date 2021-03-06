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
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService service;

    //注册学生

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView modelAndView = new ModelAndView();
        String code = "注册失败";
        //调用service处理student
        int nums = service.addStudent(student);
        if( nums > 0 ){
            //注册成功
            code = "学生【" + student.getName() + "】注册成功";
        }
        modelAndView.addObject("code",code);
        modelAndView.setViewName("forward:/WEB-INF/jsp/result.jsp");

        System.out.println(modelAndView);

        return modelAndView;
    }

    //处理查询，响应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        //参数检查， 简单的数据处理
        List<Student> students = service.findStudents();
        return students;
    }
}
