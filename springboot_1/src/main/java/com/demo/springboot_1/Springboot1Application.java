package com.demo.springboot_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan  // 扫描listener类，在应用启动的时候执行init方法，关闭的时候执行destory方法，此项目中自定义listener在listener目录
@SpringBootApplication
public class Springboot1Application {

    public static void main(String[] args) {

        SpringApplication.run(Springboot1Application.class, args);
    }

}
