package org.breeze.design.observer.JDKObserverPattern;

import java.util.Observable;
import java.util.Observer;


public class BizServiceListener implements Observer {

    @Override
    public void update(Observable o, Object obj) {
        System.out.println("观察者 监听到 被观察者 的行为！" + obj);
    }
}
