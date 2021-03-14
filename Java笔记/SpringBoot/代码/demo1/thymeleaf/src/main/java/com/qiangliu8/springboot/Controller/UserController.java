package com.qiangliu8.springboot.Controller;

import com.qiangliu8.springboot.model.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @RequestMapping(value = "/message")
    public String message(Model model){
        model.addAttribute("data","springboot集成thymeleaf");
        return "message";
    }
    @RequestMapping("/user/detail")
    public ModelAndView userDetail(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User(1001,"刘强",23);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("userDetail");
        return modelAndView;
    }

    @RequestMapping(value = "/url")
    public String urlExpression(Model model){
        model.addAttribute("name","刘强");
        model.addAttribute("id",123);
        return "url";
    }

    @RequestMapping(value = "/urlParam")
    @ResponseBody
    public String urlParam(String name){
        return "请求参数是"+name;
    }

    @RequestMapping(value = "/RESTful/{id}")
    @ResponseBody
    public String urlParam(@PathVariable("id") Integer id){
        return "请求参数是id"+id;
    }

    @RequestMapping(value = "/url2")
    public String url2(){
        return "url2";
    }
}
