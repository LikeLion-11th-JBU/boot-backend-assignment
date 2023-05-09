package jym.yoengmu.demo;

import jym.yoengmu.demo.TestIntetface;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private TestIntetface testInterface;
    public  TestComponent(
            TestIntetface testInterface,
            int gradeBean
    ) {
        this.testInterface = testInterface;
        System.out.println(gradeBean);
    }
    public void sayHello() {
        this.testInterface.sayHello();

    }
}
