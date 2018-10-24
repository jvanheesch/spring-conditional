package com.github.jvanheesch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@PropertySource(value = "classpath:application.properties", factory = EncryptedPropertySourceFactory.class)
public class PropertiesConfig {
    private static final String PASSWORD = "j22r+yODMj4Ndfewkr/ThoCJFi/N6YnE";

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
