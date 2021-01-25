package com.qiangliu8;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpServlet extends javax.servlet.http.HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig.getInitParameter("url"));
        System.out.println(servletConfig.getInitParameter("username"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("HttpServlet的doGet()方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("HttpServlet的doPost()方法");
    }
}
