package tn.esprit.demotransaction.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component

public class LoggingAspect {
    @Before(" execution(* tn.esprit.demotransaction.Service.*.*(..)) ")
    public void logMethodEntry(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + ":");
    }

    @After("execution(* tn.esprit.demotransaction.Service.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        log.info(" In method "+ name + ":");
    }




}