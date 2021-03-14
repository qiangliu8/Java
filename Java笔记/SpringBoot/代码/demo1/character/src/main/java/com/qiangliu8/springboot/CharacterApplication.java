package com.qiangliu8.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.qiangliu8.springboot.servlet")
public class CharacterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharacterApplication.class, args);
    }

}
