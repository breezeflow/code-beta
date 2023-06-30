package org.breeze.base.DesignPattern.FactoryPattern.FactoryMethod;


import org.breeze.base.DesignPattern.FactoryPattern.Human;
import org.breeze.base.DesignPattern.FactoryPattern.YellowHuman;

public class YellowHumanFactory extends AbstractFactory {
    @Override
    public Human createHuman() {
        System.out.println("黄种人");
        return new YellowHuman();
    }
}
