package com.qiangliu8.test;

import com.qiangliu8.entity.User;
import com.qiangliu8.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestUser {
    @Test
    public void testJdbcTemplate_add(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user = new User("1102644615","刘强","1");
        userService.addUser(user);
    }

    @Test
    public void testJdbcTemplate_update(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = applicationContext.getBean("userService",UserService.class);
        User user = new User("1102644615","新刘强","0");
        userService.updateUser(user);
    }

    @Test
    public void testJdbcTemplate_delete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.deleteUser("1102644615");
    }

    @Test
    public void testJdbcTemplate_qureyOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        int count = userService.findCount();
        System.out.println(count);
    }

    @Test
    public void testJdbcTemplate_qureyDetilas(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user = userService.findUserInfo("1102644615");
        System.out.println(user);
    }

    @Test
    public void testJdbcTemplate_qureyList(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        List list = userService.findUserAllList();
        System.out.println(list);
    }

    @Test
    public void testJdbcTemplate_batchAdd(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new String[]{"1", "新刘强1", "1"});
        list.add(new String[]{"2", "新刘强2", "1"});
        list.add(new String[]{"3", "新刘强3", "0"});
        userService.batchAdd(list);
    }

    @Test
    public void testJdbcTemplate_batchUpdate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new String[]{"1新刘强", "11", "1"});
        list.add(new String[]{"2新刘强", "22", "2"});
        list.add(new String[]{"3新刘强", "33", "3"});
        userService.batchUpdate(list);
    }

    @Test
    public void testJdbcTemplate_batchDelete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new String[]{"1"});
        list.add(new String[]{"2"});
        list.add(new String[]{"3"});
        userService.batchDelete(list);
    }


}
