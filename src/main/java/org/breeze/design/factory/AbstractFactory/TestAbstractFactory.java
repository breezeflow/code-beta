package org.breeze.design.factory.AbstractFactory;

public class TestAbstractFactory {

    public static void main(String[] args) {
        AbstractFactory miFactory = new MiFactory();
        AbstractFactory appleFactory = new AppleFactory();
        miFactory.makePhone();
        miFactory.makePC();
        appleFactory.makePhone();
        appleFactory.makePC();
    }

}
