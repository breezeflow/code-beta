package org.breeze.DesignPattern.ObserverPattern.CusObserverPattern;

/**
 * 李斯，韩非子的粉丝，秦老大派他偷窥韩非子
 */
public class BizServiceListener implements Observer {

    @Override
    public void action(String context) {
        System.out.println("观察者 监听到 被观察者 的行为！" + context);
    }
}
