package org.breeze.design.factory.FactoryMethod;


import org.breeze.design.factory.Human;
import org.breeze.design.factory.WhiteHuman;

public class WhiteHumanFactory extends AbstractFactory {
    @Override
    public Human createHuman() {
        System.out.println("白人");
        return new WhiteHuman();
    }
}
