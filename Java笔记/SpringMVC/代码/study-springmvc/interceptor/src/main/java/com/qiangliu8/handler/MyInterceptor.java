package com.qiangliu8.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类：拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {
    private long btime = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime = System.currentTimeMillis();
        System.out.println("1111preHandle方法");
        //request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("1111postHandle方法");
        if (modelAndView!=null){
            modelAndView.addObject("mydate",new Date());
            modelAndView.setViewName("other");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("1111afterCompletion方法");
        long etime = System.currentTimeMillis();
        System.out.println("1111共花费时间为"+(etime-btime));
    }
}
