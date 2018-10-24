package com.github.jvanheesch.nested;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ClassWithStaticContext {

    @Configuration
    public static class InnerContext {
        @Bean
        public String innerContextBean() {
            return "innerContextBean";
        }
    }
}
