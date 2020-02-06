package com.demo.springboot_1.service;

import com.demo.springboot_1.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class HelloService {

    @Autowired
    private User user;

    public void greet(){
        user.greet();
    }

}
