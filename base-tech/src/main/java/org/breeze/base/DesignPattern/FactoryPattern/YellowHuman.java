package org.breeze.base.DesignPattern.FactoryPattern;

/**
 * 不同人种：黄种人
 */
public class YellowHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黄种人会笑");
    }

    @Override
    public void cry() {
        System.out.println("黄种人会哭");
    }

    @Override
    public void talk() {
        System.out.println("黄种人会讲话");
    }
}
