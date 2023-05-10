package dev.aqushdw.gradledemo;

import org.springframework.stereotype.Component;

@Component  // 어노테이션을 붙이면, 이 문구가 testComponent는 Spring Ioc에서 관리를 하는 객체가 된다. -> bean 객체가 된다.
public class TestComponent {
    private TestInterface testInterface;
    public TestComponent(TestInterface testInterface, int gradeBean) { // testcomponent가 testInterface가 필요하다고 하자 IoC Container에서 testInterface의 구현체중 하나인 implementation을 가지고 와서 주입을 해준다.
        this.testInterface = testInterface;
        System.out.println(gradeBean);
    }
    public  void sayHello(){
        this.testInterface.sayHello();  // 인터페이스 안의 기능을 사용하고 있다.
    }
}
