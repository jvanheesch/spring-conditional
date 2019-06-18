package com.github.jvanheesch.actionfactory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class ActionFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public ProductAction productAction(Object... otherArgs) {
        return new ProductAction(this, otherArgs);
    }

    public ItemAction itemAction(Object... otherArgs) {
        return new ItemAction(this, applicationContext.getBean(SomeService.class), otherArgs);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
