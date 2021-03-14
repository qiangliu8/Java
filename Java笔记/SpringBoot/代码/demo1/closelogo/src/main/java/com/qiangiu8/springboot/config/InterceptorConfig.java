package com.qiangiu8.springboot.config;

import com.qiangiu8.springboot.interceptor.UserIntercrptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//定义此类为配置类
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //要拦截user下的所有访问请求,必须用户登录后才可访问,
        //但是这样拦截的路径中有一些是不需要用户登录也可访问的
        String[] addPathPatterns = {
            "/user/**"
        };
        //要派出的路径
        String[] excludePathPatterns = {
            "/user/out","/user/error","/user/login"
        };
        //注册拦截器
        registry.addInterceptor(new UserIntercrptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
