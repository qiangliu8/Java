package com.qiangliu8.collectiontype.Test;

import com.qiangliu8.collectiontype.Book;
import com.qiangliu8.collectiontype.Course;
import com.qiangliu8.collectiontype.autowire.Emp;
import com.qiangliu8.collectiontype.bean.Order;
import com.qiangliu8.collectiontype.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        Book book1 = applicationContext.getBean("book",Book.class);
        Book book2 = applicationContext.getBean("book",Book.class);
        System.out.println(book1==book2);
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = applicationContext.getBean("myBean", Course.class);

        System.out.println(course);
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean4.xml");
        Order order = applicationContext.getBean("order",Order.class);
        System.out.println("第四步获取创建实例对象");
        System.out.println(order);
        //手动让bean实例销毁 applicationContext父类没有close方法，需要强转实现类的close方法
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
    @Test
    public void test4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = applicationContext.getBean("emp",Emp.class);
        System.out.println(emp);
    }
}
