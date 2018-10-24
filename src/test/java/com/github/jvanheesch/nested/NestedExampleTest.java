package com.github.jvanheesch.nested;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class NestedExampleTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TopLevelConfig.class);
        assertThat(context.getBean("outerBean"))
                .isNotNull();
        assertThat(context.getBean("innerContextBean"))
                .isNotNull();
    }
}
