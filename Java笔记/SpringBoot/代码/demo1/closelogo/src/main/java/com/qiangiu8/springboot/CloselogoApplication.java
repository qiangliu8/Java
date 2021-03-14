package com.qiangiu8.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloselogoApplication {

    public static void main(String[] args) {
        //获取入口SpringBoot类
        SpringApplication springApplication = new SpringApplication(CloselogoApplication.class);
        //设置它的属性
        //springApplication.setBannerMode(Banner.Mode.OFF);

        springApplication.run(args);
    }

}
