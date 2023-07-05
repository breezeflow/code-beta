package org.breeze.DesignPattern.ObserverPattern.JDKObserverPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 李斯，韩非子的粉丝，秦老大派他偷窥韩非子
 */
public class MessageListener<T> implements Observer {

    @Override
    public void update(Observable o, Object obj) {
        System.out.println("目标有新活动了！！！");
        action(obj.toString());
        System.out.println("汇报完毕！！，继续监控。");
    }

    private void action(String context) {
        System.out.println("lisi ,报告Boss，目标有新动向："+context);
    }
}
