package com.github.jvanheesch.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SomeIntroduction {
    @DeclareParents(value = "com.github.jvanheesch.aop.SomeService+", defaultImpl = CallableImpl.class)
    public static Callable callable;

    public interface Callable {
        void call();
    }

    public static class CallableImpl implements Callable {
        @Override
        public void call() {
            System.out.println("Thank you for calling.");
        }
    }
}
