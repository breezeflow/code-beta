package org.breeze.DesignPattern.FactoryPattern.AbstractFactory;

public class MiPC implements  PC{
    @Override
    public void make() {
        System.out.println("make mi pc");
    }
}
