package org.breeze.design.factory.AbstractFactory;

public class ApplePhone implements Phone {
    @Override
    public void make() {
        System.out.println("make apple phone");
    }
}
