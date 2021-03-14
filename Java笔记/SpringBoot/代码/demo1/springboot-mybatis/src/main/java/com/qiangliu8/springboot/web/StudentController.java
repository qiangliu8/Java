package com.qiangliu8.springboot.web;

import com.qiangliu8.springboot.model.Student;
import com.qiangliu8.springboot.service.StudentService;
import com.qiangliu8.springboot.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
//
//    @RequestMapping(value = "/stu")
//    @ResponseBody
//    public Object returnStu(){
//        return studentService.selectStu(2);
//    }
//
//    @RequestMapping(value = "/update")
//    @ResponseBody
//    public Object upadte(Integer id,String name){
//        Student student = new Student(id,name,null);
//        int updateCount = studentService.updateStudent(student);
//        return "id："+id+"修改结果为："+updateCount;
//    }

    @RequestMapping(value = "/stu")
    public Object returnStu(){
        return new Student(1,"刘强",18);
    }

    //RequestMapping(value = "/getStu",method = RequestMethod.GET)
    @GetMapping("/getStu")//相当于上一句话,只接收GET请求,如果请求方式不对会报405错调
    public Object getStu(Integer id,String name){
        Student student = new Student(id,name,null);
        return student;
    }
    //RequestMapping(value = "/sendStu",method = RequestMethod.POST)
    @PostMapping("/sendStu")//相当于上一句话,只接收Post请求,如果请求方式不对会报405错调
    public Object sendStu(Integer id,String name){
        Student student = new Student(id,name,null);
        return student;
    }
    //RequestMapping(value = "/deleteStu",method = RequestMethod.DELETE)
    @DeleteMapping("/deleteStu")///该注解通常在删除数据的时候使用->删除
    public Object deleteStu(){
        return "deleteStu";
    }
    //RequestMapping(value = "/putStu",method = RequestMethod.PUT)
    @PutMapping("/putStu")///该注解通常在删除数据的时候使用->更新
    public Object putStu(Integer id,String name){
        Student student = new Student(id,name,null);
        int updateCount = studentService.updateStudent(student);
        return "id："+id+"修改结果为："+updateCount;
    }
}
