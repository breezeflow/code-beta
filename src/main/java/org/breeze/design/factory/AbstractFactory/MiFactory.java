package org.breeze.design.factory.AbstractFactory;

public class MiFactory extends AbstractFactory {
    @Override
    public Phone makePhone() {
        System.out.println("XiaoMi 13 Pro");
        return new MiPhone();
    }

    @Override
    public PC makePC() {
        System.out.println("MI  PC");
        return new MiPC();
    }
}
