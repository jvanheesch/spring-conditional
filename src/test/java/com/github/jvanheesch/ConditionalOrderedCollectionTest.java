package com.github.jvanheesch;

import com.github.jvanheesch.ConditionalOrderedCollectionTest.ConditionalOrderedCollectionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionalOrderedCollectionContext.class)
public class ConditionalOrderedCollectionTest {

    @Autowired
    private List<String> strings;

    @Test
    public void test() {
        assertThat(strings)
                .containsExactly("first", "third");
    }

    @Configuration
    public static class ConditionalOrderedCollectionContext {
        @Order(1)
        @Bean
        public String first() {
            return "first";
        }

        @Order(2)
        @Conditional(AlwaysFalseCondition.class)
        @Bean
        public String second() {
            return "second";
        }

        @Order(3)
        @Bean
        public String third() {
            return "third";
        }
    }

    private static class AlwaysFalseCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }
}
