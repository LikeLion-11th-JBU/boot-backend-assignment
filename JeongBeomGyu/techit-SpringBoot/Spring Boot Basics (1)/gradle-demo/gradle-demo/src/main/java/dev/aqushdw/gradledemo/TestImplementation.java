package dev.aqushdw.gradledemo;

import org.springframework.stereotype.Component;

@Component  // 어노테이션을 지우면 에러가 발생한다. 왜냐하면 component 어노테이션이 붙어있어야지 Spring IoC에서 이것을 검색해서 사용을 하기 때문이다.
public class TestImplementation implements  TestInterface{
    @Override
    public void sayHello() {
        System.out.println("hello, i'm a bean");
    }
}
