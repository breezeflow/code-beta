package org.breeze.design.observer.CusObserverPattern;

public class BizService extends DefaultObservable {

    public void doSomething() {
        String context = "我：韩非子，要吃饭了！！！";
        System.out.println(context);
        this.notify(context);
    }

}
