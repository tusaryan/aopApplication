package com.tusaryan.aopApp.AopAppApplication.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {


    @Before("allServiceMethodsPointCut()")
    public void beforeServiceMethodCalls(JoinPoint joinPoint) {
        log.info("Before advice method call, {}", joinPoint.getSignature());
    }

    @Pointcut("execution (* com.tusaryan.aopApp.AopAppApplication.services.impl.*.*(..))")
    public void allServiceMethodsPointCut() {}
}
