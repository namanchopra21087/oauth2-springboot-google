package com.oauth.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
/**
 * Used as an interceptor for authenticating incoming request
 */
public class EngagementAspect {

    @Pointcut("execution(* com.oauth.demo.controller.*.*(..))")
    public void controller() {
    }

    @Around("controller()")
    public Object loggingUserAuthorizationAndExceptionHandling(ProceedingJoinPoint joinPoint) {
        log.info("Inside loggingAndExceptionHandling : {}", joinPoint.getSignature().getName());
        Object result = null;

        return result;
    }
}
