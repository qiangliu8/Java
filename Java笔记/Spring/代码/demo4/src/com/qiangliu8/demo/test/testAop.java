package com.qiangliu8.demo.test;

import com.qiangliu8.demo.aopanno.User;
import com.qiangliu8.demo.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAop {
    @Test
    public void testAopAnno(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        User user = applicationContext.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testAopXml(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = applicationContext.getBean("book",Book.class);
        book.buy();
    }
}
