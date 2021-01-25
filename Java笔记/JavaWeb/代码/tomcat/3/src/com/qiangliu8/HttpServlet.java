package com.qiangliu8;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;


public class HttpServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println("真实客户端的ip:"+request.getRemoteHost());
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("hobby"));
        System.out.println(request.getParameterValues("hobby")[0]);
        System.out.println(Arrays.asList(request.getParameterValues("hobby")));

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println("真实客户端的ip:"+request.getRemoteHost());
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("hobby"));
        System.out.println(request.getParameterValues("hobby")[0]);
        System.out.println(Arrays.asList(request.getParameterValues("hobby")));
    }
}
