package com.Sung.demo;

import org.springframework.stereotype.Component;

@Component
public class NewImplementation implements TestInterface{

    @Override
    public void sayHello() {
        System.out.println("hello, i'm bean");
    }
}
