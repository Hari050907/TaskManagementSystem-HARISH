package com.example.taskmanagementsystem.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.taskmanagementsystem.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Entering: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.example.taskmanagementsystem.service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("Exiting: " + joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "execution(* com.example.taskmanagementsystem.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Exception in: " + joinPoint.getSignature());
        System.out.println("Reason: " + ex.getMessage());
    }
}
