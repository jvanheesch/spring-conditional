package com.github.jvanheesch.actionfactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.github.jvanheesch.actionfactory.ActionFactoryTest.ActionFactoryTestContext;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ActionFactoryTestContext.class)
public class ActionFactoryTest {
    @Autowired
    private ActionFactory actionFactory;

    @Test
    public void test() {
        ProductAction productAction = this.actionFactory.productAction("abc");
        ItemAction itemAction = productAction.createItemAction();
        String data = itemAction.useSomeService();
        assertThat(data)
                .isEqualTo("someData");
    }

    @Configuration
    @ComponentScan(basePackageClasses = ActionFactoryTest.class)
    public static class ActionFactoryTestContext {
    }
}
