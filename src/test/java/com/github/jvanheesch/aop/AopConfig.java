package com.github.jvanheesch.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = "com.github.jvanheesch.aop")
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {
}
