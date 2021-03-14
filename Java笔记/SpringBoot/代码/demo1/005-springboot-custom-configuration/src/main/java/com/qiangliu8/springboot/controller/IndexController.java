package com.qiangliu8.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping(value = "/say")
    @ResponseBody
    public String say(){
        return "hello-springboot-environment";
    }
    @RequestMapping(value = "/mapValue")
    @ResponseBody
    public Map<String,Object> mapValue(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","刘强");
        return map;
    }
}
