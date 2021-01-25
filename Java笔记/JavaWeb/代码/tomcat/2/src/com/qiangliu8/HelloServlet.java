package com.qiangliu8;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("这是构造器方法！");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("这是init初始化方法！");
        System.out.println("别名："+servletConfig.getServletName());
        System.out.println("初始化参数username的值是"+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是"+servletConfig.getInitParameter("url"));
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //类型转换，因为httpServletRequest有getMethod方法
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        //获取请求方式
        String method = httpServletRequest.getMethod();

        if("GET".equals(method)){
            doGET();
        }else{
            doPOST();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("这是destroy销毁方法！");
    }

    public void doGET(){
        System.out.println("GET请求");
    }

    public void doPOST(){
        System.out.println("POST请求");
    }
}
