package jym.yoengmu.demo;

import org.springframework.stereotype.Component;

@Component
public class TestImplementation implements TestIntetface {

    @Override
    public void sayHello() {
        System.out.println("Hello World!!!");

    }
}
