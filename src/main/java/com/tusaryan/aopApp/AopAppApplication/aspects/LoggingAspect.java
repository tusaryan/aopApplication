package com.tusaryan.aopApp.AopAppApplication.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    //Execution kind pointcut

//    @Before("execution(* orderPackage(..))")
//    @Before("execution(* com.tusaryan.aopApp.AopAppApplication.services.impl.ShipmentServiceImpl.orderPackage(..))")
//    @Before("execution(* com.tusaryan.aopApp.AopAppApplication.services.impl.*.orderPackage(..))")
    @Before("execution(* com.tusaryan.aopApp.AopAppApplication.services.impl.*.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint) {
        log.info("Before called from LoggingAspect kind, {}", joinPoint.getKind());
        log.info("Before called from LoggingAspect signature, {}", joinPoint.getSignature());
    }

    //Within kind pointcut

//    @Before("within(com.tusaryan.aopApp.AopAppApplication.services.impl.*)")

    //for all method in any subpackage or class inside this aopApp package, will have this aspect before their method calls.
    @Before("within(com.tusaryan.aopApp..*)")
    public void beforeServiceImplCalls() {
        log.info("Service Impl calls");
    }

    //Annotation kind pointcut

//    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")

    //to target custom annotation
//    @Before("@annotation(com.tusaryan.aopApp.AopAppApplication.aspects.MyLogging)")

    //Need of Pointcut declaration -> complex expression using && ||
//    @Before("@annotation(com.tusaryan.aopApp.AopAppApplication.aspects.MyLogging) && within(com.tusaryan.aopApp..*) || execution(* com.tusaryan.aopApp.AopAppApplication.services.impl.*.*(..))")

    @Before("myLoggingAndAopMethodsPointCut()")
    public void beforeTransactionalAnnotation() {
//        log.info("Before Transactional Annotation calls");
        log.info("Before My Logging Annotation calls");
    }

    @After("myLoggingAndAopMethodsPointCut()")
    public void afterTransactionalAnnotation() {
//        log.info("Before Transactional Annotation calls");
        log.info("After My Logging Annotation calls");
    }

    //this will not contain any action, it is just an empty method.
    @Pointcut("@annotation(com.tusaryan.aopApp.AopAppApplication.aspects.MyLogging) && within(com.tusaryan.aopApp..*)")
    public void myLoggingAndAopMethodsPointCut() {}
}
