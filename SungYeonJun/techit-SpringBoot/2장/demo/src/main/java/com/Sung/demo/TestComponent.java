package com.Sung.demo;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private TestInterface testInterface;

    public TestComponent(
            TestInterface testInterface,
            int gradeBean

    ) {
        this.testInterface = this.testInterface;
        System.out.println(gradeBean);
    }

    public void sayHello(){
        this.testInterface.sayHello();
    }
}
