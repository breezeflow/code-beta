package org.breeze.concurrency.ThreadSafe;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread running .....");

                LockSupport.park();

                System.out.println("child thread unpark.....");

            }
        });
        thread.start();

        Thread.sleep(3000);

        System.out.println("main thread unpark");

        LockSupport.unpark(thread);

    }

}
