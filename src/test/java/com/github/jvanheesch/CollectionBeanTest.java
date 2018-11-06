package com.github.jvanheesch;


import com.github.jvanheesch.CollectionBeanTest.CollectionBeanTestContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CollectionBeanTestContext.class)
public class CollectionBeanTest {
    // this does not work in spring 4 ...
    @Autowired
    private List<String> strings;

    @Test
    public void name() {
        System.out.println(strings);
    }

    @Configuration
    public static class CollectionBeanTestContext {
        @Bean
        public List<String> stringList() {
            return Collections.emptyList();
        }
    }
}
