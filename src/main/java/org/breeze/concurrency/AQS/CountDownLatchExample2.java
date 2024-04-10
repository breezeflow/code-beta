package org.breeze.concurrency.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


public class CountDownLatchExample2 {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger latchInteger = new AtomicInteger();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000 );
                        System.out.println("latch当前值为："+latchInteger.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        latch.countDown();
        System.out.println("结束");
    }

}
