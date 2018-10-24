package com.github.jvanheesch;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SomeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean someCondition = "true".equalsIgnoreCase(context.getEnvironment().getProperty("some.property"));
        System.out.println(someCondition);
        return someCondition;
    }
}
