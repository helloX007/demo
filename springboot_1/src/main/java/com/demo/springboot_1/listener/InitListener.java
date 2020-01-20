package com.demo.springboot_1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 在启动类上添加 @ServletComponentScan 注解之后，这个listener就会在应用启动的时候执行 contextInitialized 方法
 */
@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("现在 InitListener 初始化了.");
    }
}