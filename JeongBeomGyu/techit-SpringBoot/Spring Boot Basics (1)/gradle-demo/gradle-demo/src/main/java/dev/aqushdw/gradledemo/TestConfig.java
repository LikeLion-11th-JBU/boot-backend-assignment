package dev.aqushdw.gradledemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //bean으로서 정의를 해주는 용도로 사용할 수 있다.
public class TestConfig {
    @Bean
    public  int gradeBean(){
        return 10;
    }
}
