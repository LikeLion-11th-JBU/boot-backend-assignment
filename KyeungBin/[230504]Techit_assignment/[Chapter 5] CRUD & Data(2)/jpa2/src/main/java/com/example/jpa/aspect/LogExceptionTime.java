package com.example.jpa.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
// 이 annotation 인터페이스가 어떠한 것에 붙을 수 있는 것인지 정의해줌
// 현재 METHOD 이므로 함수에 적용할 수 있다는 의미

@Retention(RetentionPolicy.RUNTIME)
// 소스코드로 작성된 annotation이 실제로 어느 시점까지 컴퓨터 상에 존재할것인지에 대한 것
//
public @interface LogExceptionTime {


}
