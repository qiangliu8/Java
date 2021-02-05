package com.qiangliu8.demo.service;

import com.qiangliu8.demo.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//在注解里面value属性值可以省略不计
//默认值是类名称，首字母小写
//@Component(value = "userService") //<bean id="userService" class="..">

@Service
public class UserService {
    @Value(value = "刘强")
    private String name;
    //定义userDao属性 不需要添加set方法
    //添加注入属性注解
    @Autowired
    @Qualifier(value = "userDaoImpl1")
    private com.qiangliu8.demo.dao.userDao userDao;

    public void add(){
        System.out.println("service add...");
        userDao.add();
        System.out.println(this.name);
    }
}
