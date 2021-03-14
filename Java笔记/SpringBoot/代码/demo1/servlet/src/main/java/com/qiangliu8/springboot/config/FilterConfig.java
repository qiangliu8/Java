package com.qiangliu8.springboot.config;

import com.qiangliu8.springboot.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean myFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());

        filterRegistrationBean.addUrlPatterns("/user/*");

        return filterRegistrationBean;
    }
}
