package org.breeze.design.DutyChainPattern;

public class TestApp {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new FirstHandler());
        chain.addHandler(new SecondHandler());
        chain.addHandler(new ThirdHandler());
        chain.handle();
    }

}
