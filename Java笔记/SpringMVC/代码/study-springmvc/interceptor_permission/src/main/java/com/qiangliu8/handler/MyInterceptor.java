package com.qiangliu8.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类：拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {
   //验证登录的用户信息
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("1111preHandle方法");
        Object attr = request.getSession().getAttribute("name");
        String loginName = "";
        if (attr!=null){
            loginName = (String) attr;
        }
        if ("zs".equals(loginName)){
            return true;
        }
        request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return false;
    }

}
