package com.hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//Aop는 Aspect어노테이션 붙여야 함.
@Component
//이 클래스를 스프링 빈에 등록해 줄 때 @Component를 붙여주면 ConponemtScan으로 등록되고
// spring bean에 직접 등록해줘도 됨.(이것을 더 선호함)
public class TimeTraceAop {

    @Around("execution(* com.hello.hellospring..*(..))") //원하는 조건을적용할 수 있는데 앞의 식은 패키지 하위에 다 적용해
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
//            Object result = joinPoint.proceed();
//            return result;
//            위의 두 줄을 alt + ctrl + N => inline으로 합쳐줌(아래)
            return joinPoint.proceed();

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }

    }
}
