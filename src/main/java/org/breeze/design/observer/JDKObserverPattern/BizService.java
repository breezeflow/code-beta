package org.breeze.design.observer.JDKObserverPattern;

import java.util.Observable;

public class BizService extends Observable {

    public void doSomething(){
        String context ="触发支付";
        System.out.println(context);
        super.setChanged();
        super.notifyObservers(context);
    }



}
