package com.github.jvanheesch.nested;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NestedExampleTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TopLevelConfig.class);
    }
}
