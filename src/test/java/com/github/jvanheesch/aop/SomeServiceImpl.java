package com.github.jvanheesch.aop;

import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void someMethod() {
        System.out.println("SomeServiceImpl.someMethod");
    }
}
