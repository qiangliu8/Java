package com.qiangliu8.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2前置代码1");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter2后置代码1");
    }

    @Override
    public void destroy() {

    }
}
