package com.github.jvanheesch.actionfactory;

public class ProductAction {
    private final ActionFactory actionFactory;
    private final Object[] otherArgs;

    public ProductAction(ActionFactory actionFactory, Object... otherArgs) {
        this.actionFactory = actionFactory;
        this.otherArgs = otherArgs;
    }

    public ItemAction createItemAction() {
        return actionFactory.itemAction(this.otherArgs);
    }
}
