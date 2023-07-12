package org.breeze.design.factory.AbstractFactory;

public class ApplePC implements PC {
    @Override
    public void make() {
        System.out.println("make apple  PC");
    }
}
