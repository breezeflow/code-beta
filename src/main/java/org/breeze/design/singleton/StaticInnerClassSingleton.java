package org.breeze.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类实现单例模式
 *
 * 饿汉式，但又能实现懒加载
 */
public class StaticInnerClassSingleton {

    private AtomicLong id = new AtomicLong(0);

    private StaticInnerClassSingleton(){}

    private static class SingleInstanceHolder{
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public StaticInnerClassSingleton getInstance(){
        return SingleInstanceHolder.instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }

}
