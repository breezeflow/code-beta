package org.breeze.design.DutyChainPattern;

public class SecondHandler extends BaseHandler {
    @Override
    protected boolean doHandle() {
        System.out.println("第二步");
        return true;
    }
}
