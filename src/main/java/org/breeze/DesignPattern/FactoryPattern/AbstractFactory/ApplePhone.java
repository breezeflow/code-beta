package org.breeze.DesignPattern.FactoryPattern.AbstractFactory;

public class ApplePhone implements Phone {
    @Override
    public void make() {
        System.out.println("make apple phone");
    }
}
