package com.qiangliu8.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("这是AdminFilter构造器方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("这是AdminFilter的init方法");
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("username"));
        System.out.println(filterConfig.getInitParameter("url"));
        System.out.println(filterConfig.getServletContext());
    }

    //专门用来拦截请求，可以做权限检查
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("这是AdminFilter的doFilter方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user  = session.getAttribute("user");
        if (user==null){
            httpServletRequest.getRequestDispatcher("./login.jsp").forward(servletRequest,servletResponse);
            return;
        }else{
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("这是AdminFilter的destroy方法");
    }
}
