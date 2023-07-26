package org.breeze.concurrency.Lock;

public class SynchronizedDemo {

    {
        synchronized (this){
            System.out.println("静态代码块，锁对象");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    {
        synchronized (SynchronizedDemo.class){
            System.out.println("静态代码块，锁类");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        SynchronizedDemo demo1 = new SynchronizedDemo();

        new Thread(() -> {
            try {
                demo.testSynchronized2("001");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread1").start();

        new Thread(() -> {
            try {
                demo.testSynchronized2("002");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2").start();
    }

    public void testSynchronized(String key) throws InterruptedException {
        synchronized (key) {
            System.out.println("同步代码块，锁内容：" + key);
            Thread.sleep(3000);
        }
    }

    public synchronized void testSynchronized2(String key) throws InterruptedException {
        System.out.println("同步代码块，锁内容：" + key);
        Thread.sleep(4000);
    }

}
