package com.github.jvanheesch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ExampleTest {
    static {
        System.setProperty("some.property", "false");
    }

    @Autowired
    private SomeBean someBean;

    @Test
    public void contextTest() {
        System.out.println("ExampleTest.contextTest");
    }
}
