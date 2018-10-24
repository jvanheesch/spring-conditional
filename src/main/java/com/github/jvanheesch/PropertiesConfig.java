package com.github.jvanheesch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@PropertySource("classpath:application.properties")
public class PropertiesConfig {
    @Bean
//    @DependsOn("myProperties")
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

//    @Bean
//    public Properties myProperties(ConfigurableEnvironment environment) throws IOException {
//        Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.properties"));
//        environment.getPropertySources().addFirst(new PropertiesPropertySource("test", properties));
//        return properties;
//    }
}
