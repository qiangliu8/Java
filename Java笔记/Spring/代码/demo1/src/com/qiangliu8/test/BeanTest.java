package com.qiangliu8.test;

import com.qiangliu8.bean.Emp;
import com.qiangliu8.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void testOrders(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.add();
    }
    @Test
    public void testBean3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = applicationContext.getBean("emp",Emp.class);
        System.out.println(emp);
    }
}
