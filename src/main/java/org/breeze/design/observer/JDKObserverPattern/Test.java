package org.breeze.design.observer.JDKObserverPattern;

/**
 * 观察者模式  旁观者（吃瓜群众）
 */
public class Test {

    public static void main(String[] args) {
        // 业务服务
        BizService bizService = new BizService();

        // 添加监听器（观察者）
        bizService.addObserver(new BizServiceListener());

        //注意：JDK自带的观察者模式，在实现时，先后顺序 同自己实现的观察者模式顺序不一样。
        bizService.doSomething();
    }

}
