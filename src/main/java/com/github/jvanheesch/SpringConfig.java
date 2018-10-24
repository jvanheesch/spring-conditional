package com.github.jvanheesch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(PropertiesConfig.class)
@Configuration
public class SpringConfig {

    @Conditional(SomeCondition.class)
    @Bean
    public SomeBean someBean() {
        return new SomeBean();
    }
}
