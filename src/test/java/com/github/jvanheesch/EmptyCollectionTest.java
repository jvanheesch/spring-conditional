package com.github.jvanheesch;

import com.github.jvanheesch.EmptyCollectionTest.EmptyCollectionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmptyCollectionContext.class)
public class EmptyCollectionTest {

    @Autowired(required = false)
    private List<String> strings = new LinkedList<>();

    @Autowired(required = false)
    private List<Integer> integers = new LinkedList<>();

    @Test
    public void test_empty() {
        assertThat(strings)
                .isNotNull()
                .isExactlyInstanceOf(LinkedList.class)
                .isEmpty();
    }

    @Test
    public void test_not_empty() {
        assertThat(integers)
                .isNotNull()
                .isNotExactlyInstanceOf(LinkedList.class)
                .containsExactly(1);
    }

    @Configuration
    public static class EmptyCollectionContext {
        @Bean
        public Integer someInteger() {
            return 1;
        }
    }
}
