package com.qiangliu8.springboot.controller;


import com.qiangliu8.springboot.service.StudenService;
import com.qiangliu8.springboot.service.StudenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudenService service;
    @RequestMapping(value = "/count")
    public String studentCount(){

        return "学生总人数为："+service.studentCount();
    }
}
