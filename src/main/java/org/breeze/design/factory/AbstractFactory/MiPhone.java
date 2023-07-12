package org.breeze.design.factory.AbstractFactory;

public class MiPhone implements Phone {
    @Override
    public void make() {
        System.out.println("make mi phone");
    }
}
