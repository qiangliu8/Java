package com.qiangliu8.springboot.web;

import com.qiangliu8.springboot.service.StudentService;
import com.qiangliu8.springboot.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/student")
    @ResponseBody
    public Object student(){
        return studentService.queryStudentById(1);
    }
}
