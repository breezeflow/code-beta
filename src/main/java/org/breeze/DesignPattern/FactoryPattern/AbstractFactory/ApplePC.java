package org.breeze.DesignPattern.FactoryPattern.AbstractFactory;

public class ApplePC implements PC {
    @Override
    public void make() {
        System.out.println("make apple  PC");
    }
}
