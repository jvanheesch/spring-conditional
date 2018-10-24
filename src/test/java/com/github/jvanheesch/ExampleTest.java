package com.github.jvanheesch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ExampleTest {
    @Autowired
    private SomeBean someBean;
    @Value("${some.encrypted.property}")
    private String someEncryptedProperty;

    @Test
    public void contextTest() {
        assertThat(someEncryptedProperty)
                .isEqualTo("hello");
    }
}
