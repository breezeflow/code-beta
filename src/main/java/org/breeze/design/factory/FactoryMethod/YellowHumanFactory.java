package org.breeze.design.factory.FactoryMethod;


import org.breeze.design.factory.Human;
import org.breeze.design.factory.YellowHuman;

public class YellowHumanFactory extends AbstractFactory {
    @Override
    public Human createHuman() {
        System.out.println("黄种人");
        return new YellowHuman();
    }
}
