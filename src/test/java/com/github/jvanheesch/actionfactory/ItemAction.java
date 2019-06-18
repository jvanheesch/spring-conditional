package com.github.jvanheesch.actionfactory;

public class ItemAction {
    private final ActionFactory actionFactory;
    private final SomeService someService;
    private final Object[] otherArgs;

    public ItemAction(ActionFactory actionFactory, SomeService someService, Object... otherArgs) {
        this.actionFactory = actionFactory;
        this.someService = someService;
        this.otherArgs = otherArgs;
    }

    public String useSomeService() {
        return this.someService.getSomeData();
    }
}
