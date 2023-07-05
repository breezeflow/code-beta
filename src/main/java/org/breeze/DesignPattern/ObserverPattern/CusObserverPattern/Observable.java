package org.breeze.DesignPattern.ObserverPattern.CusObserverPattern;

/**
 * 被观察者 接口
 */
public interface Observable {

    /**
     * 添加观察者
     *
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     *
     * @param context
     */
    void notify(String context);


}
