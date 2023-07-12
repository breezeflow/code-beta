package org.breeze.design.DutyChainPattern;

public class ThirdHandler extends BaseHandler {
    @Override
    protected boolean doHandle() {
        System.out.println("第三步");
        return true;
    }
}
