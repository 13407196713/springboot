package com.southwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@SpringBootApplication 表示当前类是 Spring Boot 的入口
Application 类的存放位置必须是其他相关业务类的存放位置的父级
* */
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
