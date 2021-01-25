package com.qiangliu8.json;

import com.google.gson.Gson;
import com.qiangliu8.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet{

    protected void javascriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ajax请求过来了");
        response.setContentType("text/html; charset=UTF-8");
        Person person = new Person(1,"刘强");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        try {
            Thread.sleep(3000);
            response.getWriter().write(personJson);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    protected void jqAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jqAjax请求过来了");
        response.setContentType("text/html; charset=UTF-8");
        Person person = new Person(1,"刘强");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        response.getWriter().write(personJson);
    }
    protected void jqserialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jqAjax请求过来了");
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        response.setContentType("text/html; charset=UTF-8");
        Person person = new Person(1,"刘强");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        response.getWriter().write(personJson);
    }
}
