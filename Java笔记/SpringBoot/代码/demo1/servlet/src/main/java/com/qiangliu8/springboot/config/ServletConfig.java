package com.qiangliu8.springboot.config;

import com.qiangliu8.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;

@Configuration//该注解将此类定义配置类（相当于xml文件）
public class ServletConfig {
    //@Bean是一个方法上级别的注解，主要用在配置类型上
    //相当于
 /*   <beans>
        <bean id="" class=""/>
    </beans>
*/
    @Bean
    public ServletRegistrationBean myRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/springboot_servlet");

        return servletRegistrationBean;
    }
}
