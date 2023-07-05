package org.breeze.DesignPattern.ObserverPattern.CusObserverPattern;

/**
 * 观察者 接口
 */
public interface Observer {

    /**
     * 观察者获取到通知后的 作业
     *
     * @param context
     */
    void action(String context);

}