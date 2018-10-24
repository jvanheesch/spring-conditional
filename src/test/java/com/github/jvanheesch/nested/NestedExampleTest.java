package com.github.jvanheesch.nested;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class NestedExampleTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TopLevelConfig.class);
        assertThat(context.getBean("outerBean"))
                .isNotNull();
        assertThat(context.getBeansOfType(String.class))
                .doesNotContainValue("innerContextBean");
    }

    @Test
    public void testFilter() {
        String metadataClassName = "com.github.jvanheesch.nested.ClassWithStaticContext$InnerContext";
        Pattern pattern = Pattern.compile(".*\\$InnerContext*");
        System.out.println(pattern.toString());
        assertThat(pattern.matcher(metadataClassName).matches())
                .isTrue();
    }
}
