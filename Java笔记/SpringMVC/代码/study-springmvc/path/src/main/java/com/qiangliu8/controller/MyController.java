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

    @RequestMapping(value = "/user/some")
    public ModelAndView doSome(Student student){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname",student.getName());
        modelAndView.addObject("myage",student.getAge());
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }
}
