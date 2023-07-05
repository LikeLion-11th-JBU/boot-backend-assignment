package com.example.jpa.aspect;

import com.example.jpa.PostController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
// aspectj 에 대해 잘 알아야 한다.........
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around(value = "@annotation(LogExceptionTime)") // 여기에 들어가는 이름이 실제 annotation 의 클래스 이름과 동일해야 함
    // 특정한 join point 를 기준으로 그 주위에서 작동하게 되는 함수일 때 사용해주는 annotation
    // value 에 LogExecutionTime 이라는 annotation 주변에서 일어나는 함수가
    // 바로 이 함수 (public Object 이하) 이다. 라는 의미

    public Object LogExceptionTime(
            ProceedingJoinPoint joinPoint
    ) throws Throwable { // 모든 Exception (예외)의 상위 인터페이스 Throwable
        long startTime = System.currentTimeMillis(); // 검색해보기

        Object proceed = joinPoint.proceed();
        // proceed 가 붙어서 확장된 개념으로
        // (질문) 다음에 실행되어야 할 advice 혹은 그 함수 자체로 진행을 한다는 의미 (진짜 무슨소리지)
        // 한마디로 조인포인트... 마다 아래 함수들을 실행한다는 의미인가?
        // 아 loggingaspect 어노테이션을 집어넣은 메서드를 실행할 때마다 아래 함수들을 실행한다는 의미인 것 같다.

        long execTime = System.currentTimeMillis() - startTime;
        logger.trace("method executed in {}", execTime);
        return proceed;
//        return null; // (질문) 이거 뭐지... place holder로 쓴다? 자리 메꿔주기?
    }

    @Before(value = "@annotation(LogArguments)")
    public void logArguments(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.trace("method description: [{}]", methodSignature.getMethod());

        logger.trace("method name: [{}]", methodSignature.getName());

        logger.trace("declaring class: [{}]", methodSignature.getDeclaringType());

        Object[] arguments = joinPoint.getArgs();
        if (arguments.length == 0){
            logger.trace("no arguments");
        }
        for (Object argument: arguments){
            logger.trace("argument: [{}]", argument);
        }
    }

    @AfterReturning(
            value = "@annotation(LogReturn)", returning = "returnValue"
    )
    // 반환값이 존재하는 함수에 대해서 pointcut을 지정해줄 수 있다.
    // => 반환값을 받아오기 위해 사용하는 것이다.

    // returning => 반환하는 값을 이 함수(public void logResult)에 Autowire를 시켜주어야 하는데,
    // 이 때 어떤 인자에 autowire를 시킬지 결정하는 것이 returning 이다.

    // AfterReturning annotation을 aspectj에서 읽어서
    // returnValue 이름을 가진 인자에 반환값을 대입을 해줌.

    public void logResults(JoinPoint joinPoint, Object returnValue) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.trace("method name: [{}]", methodSignature.getName());

        logger.trace("return type: [{}]", methodSignature.getReturnType());

        logger.trace("return value: [{}]", returnValue);
    }


}
