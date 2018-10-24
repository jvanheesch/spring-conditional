package com.github.jvanheesch.nested;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = {"com.github.jvanheesch.nested"},
        excludeFilters = @Filter(
                type = FilterType.REGEX,
                pattern = ".*\\$InnerContext*"
        )
)
@Configuration
public class TopLevelConfig {
    @Bean
    public String outerBean() {
        return "outerBean";
    }
}
