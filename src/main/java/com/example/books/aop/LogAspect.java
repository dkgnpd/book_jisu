package com.example.books.aop;

import org.aspectj.lang.ProceedingJoinPoint; 
import org.aspectj.lang.annotation.Around;   
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.example.books.controller..*(..))")
    public void beforeMethod() {
        System.out.println("메서드 실행 전입니다.");
    }

    @Around("execution(* com.example.books.controller..*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // 전 처리
        String methodName = joinPoint.getSignature().getName(); 
        Object[] args = joinPoint.getArgs();

        System.out.println("시작: " + methodName );
        System.out.println("매개변수: " + Arrays.toString(args));

        // 실제 메서드 실행
        Object result = joinPoint.proceed();

        // 후 처리
        System.out.println("반환값: " + result);
        System.out.println(" 종료: " + methodName );

        return result; 
    }
}