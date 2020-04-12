package ru.iteko.nlmk.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogableAspect {

    @Pointcut("execution(@Logable * ru.iteko.nlmk.service.*.*(..))")
    private void selectServicies(){}

    @Pointcut("execution(@Logable * ru.iteko.nlmk.controller.*.*(..))")
    private void selectControllers(){}

    @Around("selectServicies()")
    public void sendService(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("*** start " + joinPoint.getSignature().getDeclaringTypeName() + " ***");
        joinPoint.proceed();
        log.info("*** end " + joinPoint.getSignature().getDeclaringTypeName() + " ***");
    }

    @Around("selectControllers()")
    public void sendController(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("***** start " + joinPoint.getSignature().getDeclaringTypeName() + " *****");
        joinPoint.proceed();
        log.info("***** end " + joinPoint.getSignature().getDeclaringTypeName() + " *****");
    }
}
