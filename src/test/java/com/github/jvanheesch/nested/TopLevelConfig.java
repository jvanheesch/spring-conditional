package com.github.jvanheesch.nested;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.github.jvanheesch.nested"})
@Configuration
public class TopLevelConfig {
    @Bean
    public String outerBean() {
        return "outerBean";
    }
}
