package org.breeze.DesignPattern.ObserverPattern.CusObserverPattern;

public class BizService extends DefaultObservable {

    public void doSomething() {
        String context = "我：韩非子，要吃饭了！！！";
        System.out.println(context);
        this.notify(context);
    }

}
