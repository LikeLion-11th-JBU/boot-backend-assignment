package dev.aquashdw.jpa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    // advice 로 작동할 함수이다.
    // 이 advice 를 실제로 프로그램상에 적용을 하기 위해서 어떠한 JoinPonit 에 들어갈 지에 대한 정의를 하는 PointCut이 필요했다. 이 PointCut 또한 어노테이션으로 작성을 해준다.
    @Around(value = "@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{      //Throwable 은 모든 예외의 상위 인터페이스이다.
        long startTime = System.currentTimeMillis();//실행 시간을 재야함으로
        Object proceed = joinPoint.proceed();
        long execTime = System.currentTimeMillis() - startTime;
        logger.trace("method executed in {}", execTime);
        return proceed;
    }

    @Before(value = "@annotation(LogParameters)")
    public void logParameters(JoinPoint joinPoint) {// 실행되기 전에만 잠시 들렸다 돌아가는 함수이다.
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // type 변환이 일어났는데 signature가 맞지 않는다는 오류는 함수의 인자나 반환값이 기대한 것과 다를때 문제가 발생하는데, 그러한 함수가 어떠한 모양을 가지고 있는지를 signature 라고 이야기를 하고, 그 signature를 joinPoint에서 가져오게 된다. 근데 이것이 MethodSignature인지는 JoinPoint 인터페이스 자체에는 들어가져있지 않기 때문에 type 변환이 일어나야한다.(형변환이 일아나야된다.)
        logger.trace("method description: [{}]", methodSignature.getMethod());
        logger.trace("method name: [{}]", methodSignature.getName());
        logger.trace("declaring class: [{}]", methodSignature.getDeclaringType());

        Object[] arguments = joinPoint.getArgs();
        if(arguments.length == 0){
            logger.trace("no arguments");
        }
        for(Object argument: arguments){
            logger.trace("argument[{}]", arguments);
        }
    }

    @AfterReturning(value = "@annotation(LogReturn)", returning = "returnValue")
    public void logResults(JoinPoint joinPoint, Object returnValue ){      // 위에 있던 함수들이랑 첫 인자는 같다 하지만 두번째 인자에는 반환하는 값을 이 함수에다가 AutoWired 를 시켜줘야한다. 어떤 인자에다가 AutoWired 를 시켜줄지 정하기 위해서 returning 이라는 부분이 들어간다. 이렇게 하면 AfterReturning 이라는 어노테이션을 읽어서 returnVlaue라는 이름을 가진 인자에다가 반환값을 대입 해준다.
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.trace("method name: [{}]", methodSignature.getName());
        logger.trace("return type: [{}]", methodSignature.getReturnType());
        logger.trace("return value: [{}]", returnValue);
    }
}
