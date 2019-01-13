package com.github.jvanheesch.aop;

import com.github.jvanheesch.aop.SomeIntroduction.Callable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopConfig.class)
public class AopTest {

    @Autowired
    private SomeService someService;
    @Autowired
    private Callable callable;

    @Test
    public void someTest() {
        someService.someMethod();
    }

    @Test
    public void testIntroduction1() {
        ((Callable) someService).call();
    }

    @Test
    public void testIntroduction2() {
        callable.call();
    }
}
