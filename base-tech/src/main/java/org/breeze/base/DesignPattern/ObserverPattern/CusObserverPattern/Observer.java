package org.breeze.base.DesignPattern.ObserverPattern.CusObserverPattern;

/**
 * 观察者 接口
 */
public interface Observer {

    /**
     * 一观察到个风吹草动就开始行动
     *
     * @param context
     */
    void action(String context);

}
