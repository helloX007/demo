package com.demo.springboot_1.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
@Getter
@Setter
public class User {
    private String userName = "张三丰";
    private String address = "武当山";

    public void greet(){
        System.out.println("Hello,My Name Is "+this.userName);
    }
}
