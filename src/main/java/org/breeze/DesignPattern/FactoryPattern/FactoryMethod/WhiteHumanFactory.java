package org.breeze.DesignPattern.FactoryPattern.FactoryMethod;


import org.breeze.DesignPattern.FactoryPattern.Human;
import org.breeze.DesignPattern.FactoryPattern.WhiteHuman;

public class WhiteHumanFactory extends AbstractFactory {
    @Override
    public Human createHuman() {
        System.out.println("白人");
        return new WhiteHuman();
    }
}
