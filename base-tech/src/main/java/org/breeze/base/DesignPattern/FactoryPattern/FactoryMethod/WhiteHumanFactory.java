package org.breeze.base.DesignPattern.FactoryPattern.FactoryMethod;


import org.breeze.base.DesignPattern.FactoryPattern.Human;
import org.breeze.base.DesignPattern.FactoryPattern.WhiteHuman;

public class WhiteHumanFactory extends AbstractFactory {
    @Override
    public Human createHuman() {
        System.out.println("白人");
        return new WhiteHuman();
    }
}
