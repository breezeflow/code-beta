package org.breeze.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一：同一个线程对应同一个对象，联想：ThreadLocal
 * 进程唯一：进程唯一  ->  线程唯一
 */
public class ThreadOnlyIdGenerator {

    private AtomicLong  id = new AtomicLong(0);

    private static final ConcurrentHashMap<Long,ThreadOnlyIdGenerator> instances = new ConcurrentHashMap<>();

    private ThreadOnlyIdGenerator(){}

    public static ThreadOnlyIdGenerator getInstance(){
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId,new ThreadOnlyIdGenerator());
        return instances.get(currentThreadId);
    }

    public Long getId(){
        return ThreadOnlyIdGenerator.getInstance().getId();
    }



}
