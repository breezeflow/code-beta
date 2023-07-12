package org.breeze.design.DutyChainPattern;

public class HandlerChain {

    private BaseHandler head = null;
    private BaseHandler tail = null;

    //添加责任链到尾部
    public void addHandler(BaseHandler handler) {
        handler.setHandler(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setHandler(handler);
        tail = handler;
    }

    //责任链 从头开始执行
    public void handle() {
        if (head != null) {
            head.handle();
        }
    }

}
