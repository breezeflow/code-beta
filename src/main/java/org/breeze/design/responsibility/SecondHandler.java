package org.breeze.design.responsibility;

public class SecondHandler extends BaseHandler {
    @Override
    protected boolean doHandle() {
        System.out.println("第二步");
        return true;
    }
}
