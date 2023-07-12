package org.breeze.design.factory.AbstractFactory;

public class AppleFactory extends AbstractFactory {
    @Override
    public Phone makePhone() {
        System.out.println("iphone 13");
        return new ApplePhone();
    }

    @Override
    public PC makePC() {
        System.out.println("MacBook Pro M2");
        return new ApplePC();
    }
}
