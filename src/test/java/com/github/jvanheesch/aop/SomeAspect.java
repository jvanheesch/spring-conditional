package com.github.jvanheesch.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SomeAspect {
    public SomeAspect() {
        System.out.println("SomeAspect.SomeAspect");
    }

    // @AfterReturning("execution(* com.github.jvanheesch..*SomeService.*(..)) ")
    @AfterReturning("execution(* com.github.jvanheesch..*(..)) ")
    private void advice() {
        System.out.println("SomeAspect.advice");
    }
}
