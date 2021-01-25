package com.qiangliu8;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HttpServlet3")
public class HttpServlet3 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext =  getServletConfig().getServletContext();
        System.out.println("username:"+servletContext.getInitParameter("username"));
        System.out.println("password:"+servletContext.getInitParameter("password"));
        System.out.println("当前工程路径:"+servletContext.getContextPath());
        System.out.println("工程部署的路径："+servletContext.getRealPath("/"));
        System.out.println("工程下CSS目录的绝对路径："+servletContext.getRealPath("/"));

        ServletContext servletContext1 = getServletContext();
        servletContext1.setAttribute("name","俞文竹");
        System.out.println(servletContext1.getAttribute("name"));
    }
}
