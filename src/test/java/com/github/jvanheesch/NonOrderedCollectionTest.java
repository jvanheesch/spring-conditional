package com.github.jvanheesch;

import com.github.jvanheesch.NonOrderedCollectionTest.NonOrderedCollectionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NonOrderedCollectionContext.class)
public class NonOrderedCollectionTest {

    @Autowired
    private List<String> strings;

    @Test
    public void test() {
        assertThat(strings)
                .containsExactlyInAnyOrder("first", "second", "third");
    }

    @Configuration
    public static class NonOrderedCollectionContext {
        @Bean
        public String first() {
            return "first";
        }

        @Bean
        public String second() {
            return "second";
        }

        @Bean
        public String third() {
            return "third";
        }
    }
}
