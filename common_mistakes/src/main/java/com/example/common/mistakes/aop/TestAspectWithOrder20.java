package com.example.common.mistakes.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:26 on 2020/5/7
 * @version V0.1
 * @classNmae TestAspectWithOrder10
 */
@Aspect
@Component
@Order(10)
@Slf4j
public class TestAspectWithOrder20 {

    @Before("execution(* com.example.common.mistakes.controller.TestController.*(..))")
    public void before(JoinPoint joinPoint) throws Throwable {
        log.info("TestAspectWithOrder20 @Before");
    }

    @After("execution(* com.example.common.mistakes.controller.TestController.*(..))")
    public void after(JoinPoint joinPoint) throws Throwable {
        log.info("TestAspectWithOrder20 @After");
    }

    @Around("execution(* com.example.common.mistakes.controller.TestController.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("TestAspectWithOrder20 @Around before");
        Object o = pjp.proceed();
        log.info("TestAspectWithOrder20 @Around after");
        return o;
    }
}
