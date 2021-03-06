package com.qiangliu8.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类：拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {
    private long btime = 0;
    /*
    preHandle叫做预处理方法
    参数：
    Object handler 被拦截的控制器对象 返回值是bool值
    特点：
        1.方法在控制器方法（MyController的doSome）之前先执行的
         用户的请求首先到达此方法

         2.可以验证用户是否登录，验证用户是否有权限访问某个连接地址( url)如果验证失败，
         可以截断请求，请求不能被处理。
         如果验证成功，可以放行请求，此时控制器方法才能执行
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime = System.currentTimeMillis();
        System.out.println("1111preHandle方法");
        //request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return false;
    }
    /*
    preHandle叫做后处理方法
    参数：
    Object handler 被拦截的控制器对象
    ModelAndView mv :处理器方法的返回值
    特点：
        1.方法在控制器方法（MyController的doSome）之后执行的
        2.能够获取到处理器方法的返回值ModelAndView，可以修改ModelAndView中的数据和视图，可以影响到最后的执行结果
        3.主要对原来的执行结果做二次修正
    */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("1111postHandle方法");
        if (modelAndView!=null){
            modelAndView.addObject("mydate",new Date());
            modelAndView.setViewName("other");
        }
    }
    /*
    afterCompletion
    参数：
    Object handler 被拦截的控制器对象
    Exception ex 程序中发生的异常
    特点：
        1.在请求处理完成后执行的。规定当你的是太古处理完成之后，对试图执行了forward。就认为请求处理完成
        2.一般做资源回收工作，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存回收。
    */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("111afterCompletion方法");
        long etime = System.currentTimeMillis();
        System.out.println("111共花费时间为"+(etime-btime));
    }
}
