package org.breeze.base.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 全局ID生成器
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator(){};

    public static IdGenerator getInstance(){
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //测试多线程下 是否安全
        for(int i = 0;i<10;i++){
            final int index = i+1;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task : "+index+" id: "+IdGenerator.getInstance().getId());
                }
            });
        }

    }

}
