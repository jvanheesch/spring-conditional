package com.github.jvanheesch;

import com.github.jvanheesch.OrderedCollectionTest.OrderedCollectionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrderedCollectionContext.class)
public class OrderedCollectionTest {

    @Autowired
    private List<String> strings;

    @Test
    public void test() {
        assertThat(strings)
                .containsExactly("first", "second", "third");
    }

    @Configuration
    public static class OrderedCollectionContext {
        @Order(1)
        @Bean
        public String first() {
            return "first";
        }

        @Order(2)
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
}
