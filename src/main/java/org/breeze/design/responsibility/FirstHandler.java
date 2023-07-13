package org.breeze.design.responsibility;

public class FirstHandler extends BaseHandler {
    @Override
    protected boolean doHandle() {
        System.out.println("第一步");
        return true;
    }
}
