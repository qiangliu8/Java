package com.qiangliu8.demo.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect
@Order(1)
public class UserProxy {
    //相同切入点抽取
    @Pointcut(value = "execution(* com.qiangliu8.demo.aopanno.User.add(..))")
    public void pointcut(){
    }

    @Before(value = "pointcut()")
    public void before(){
        System.out.println("前置方法。。。");
    }

//    //前置通知
//    //@Before注解表示作为前置通知
//    @Before(value="execution(* com.qiangliu8.demo.aopanno.User.add(..))")
//    public void before(){
//        System.out.println("前置方法。。。");
//    }


    //后置通知（返回通知）
    @AfterReturning(value = "execution(* com.qiangliu8.demo.aopanno.*.*(..))")
    public void afterReturn(){
        System.out.println("AfterReturning。。。");
    }

    @After(value = "execution(* com.qiangliu8.demo.aopanno.User.add(..))")
    public void after(){
        System.out.println("后置方法。。。");
    }

    @AfterThrowing(value = "execution(* com.qiangliu8.demo.aopanno.User.add(..))")
    public void afterThrow(){
        System.out.println("AfterThrowing。。。");
    }
    //环绕通知
    @Around(value = "execution(* com.qiangliu8.demo.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("这是环绕之前");
        //被增强方法执行
        proceedingJoinPoint.proceed();
        System.out.println("这是环绕之后");
    }
}
