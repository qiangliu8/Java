package com.qiangliu8.springboot;

import com.qiangliu8.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaApplication implements CommandLineRunner{

    @Autowired
    private StudentService service;


    public static void main(String[] args) {

        //SpringBoot启动程序，会初始化Spring容器
        SpringApplication.run(JavaApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        //调用业务方法
        String str = service.sayHello();
        System.out.println(str);
    }

// public static void main(String[] args) {
//        /*SpringBoot程序启动后，返回值是ConfigurableApplicationConext,它也是Spring容器
//        * 相当于原来Spring启动容器ClassPathxmlApplicationContext
//        * */
//        //获取SpringBoot容器
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(JavaApplication.class, args);
//
//        //从Spring容器中获取Bean对象kS
//        StudentService service = (StudentService) applicationContext.getBean("studentService");
//
//        System.out.println(service.sayHello());
//    }

}
