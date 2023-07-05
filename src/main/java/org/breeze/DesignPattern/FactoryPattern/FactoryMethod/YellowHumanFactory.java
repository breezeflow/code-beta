package org.breeze.DesignPattern.FactoryPattern.FactoryMethod;


import org.breeze.DesignPattern.FactoryPattern.Human;
import org.breeze.DesignPattern.FactoryPattern.YellowHuman;

public class YellowHumanFactory extends AbstractFactory {
    @Override
    public Human createHuman() {
        System.out.println("黄种人");
        return new YellowHuman();
    }
}
