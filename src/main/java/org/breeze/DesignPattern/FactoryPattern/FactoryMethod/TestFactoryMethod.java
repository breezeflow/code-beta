package org.breeze.DesignPattern.FactoryPattern.FactoryMethod;


import org.breeze.DesignPattern.FactoryPattern.Human;

public class TestFactoryMethod {

    public static void main(String[] args) {
        AbstractFactory whiteHumanFactory = new WhiteHumanFactory();
        AbstractFactory yellowHumanFactory = new YellowHumanFactory();

        Human human = whiteHumanFactory.createHuman();
        Human human1 = yellowHumanFactory.createHuman();
    }

}
