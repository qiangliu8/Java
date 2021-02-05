package com.qiangliu8.test;

import com.qiangliu8.spring5.Book;
import com.qiangliu8.spring5.Order;
import com.qiangliu8.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testAdd(){
        //1.加载Spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置创建的对象
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testBook(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = applicationContext.getBean("book2", Book.class);
        System.out.println(book);
    }

    @Test
    public void testOrder(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        Order order = applicationContext.getBean("orders",Order.class);
        System.out.println(order);
    }
}
