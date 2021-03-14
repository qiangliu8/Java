package com.qiangliu8.springboot.controller;

import com.qiangliu8.springboot.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @RequestMapping(value = "/stu")
    public String student(Integer id,Integer age){
        Student student = new Student(id,"参数创建名",age);
        return String.valueOf(student);
    }

    @RequestMapping(value = "/stu2/{id}/{age}")
    public String student2(@PathVariable("id")Integer id,@PathVariable Integer age){
        Student student = new Student(id,"参数创建名",age);
        return String.valueOf(student);
    }
    @GetMapping(value = "/stu3/{id}/{age}")
    public String student3(@PathVariable("id")Integer id,@PathVariable Integer age){
        Student student = new Student(id,"参数创建名",age);
        return String.valueOf(student);
    }
    @PostMapping(value = "/stu3/{age}/{id}")
    public String student4(@PathVariable("id")Integer id,@PathVariable Integer age){
        Student student = new Student(id,"参数创建名",age);
        return String.valueOf(student);
    }
}
