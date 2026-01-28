package com.example.books.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // controller 패키지 안의 모든 메서드 실행 전
    @Before("execution(* com.example.books.controller..*(..))")
    public void beforeMethod() {
        System.out.println("메서드 실행합니다!");
    }
}