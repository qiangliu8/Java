package com.qiangliu8.shiwu.test;

import com.qiangliu8.entity.User;
import com.qiangliu8.shiwu.config.TxConfig;
import com.qiangliu8.shiwu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.management.PlatformLoggingMXBean;
import java.util.List;

public class UserTest {

    @Test
    public void testAccount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.accountMoney("1","2",100);
    }
    @Test
    public void testAccountXml(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.accountMoney("1","2",100);
    }
    @Test
    public void testAccountAnno(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.accountMoney("1","2",100);
    }
}
