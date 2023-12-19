package org.breeze.concurrency.ThreadPool;

import java.util.concurrent.locks.LockSupport;

/**
 * @author andy
 */
public class ThreadStatusDemo {

    public static void main(String[] args) throws Exception {

        parkUnPark();
    }

    public static void parkUnPark() {
        Thread worker = new Thread(new Work());
        System.out.println("worker: " + worker.getState());
        worker.start();
        Thread boss = new Thread(new Boss(worker));
        System.out.println("boss: " + boss.getState());
        boss.start();
    }

    static class Boss implements Runnable {

        private Thread worker;

        public Boss(Thread worker) {
            this.worker = worker;
        }

        @Override
        public void run() {
            System.out.println("boss: " + Thread.currentThread().getState());
            System.out.println("watch worker ... ");
            try {
                Thread.sleep(6000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            LockSupport.unpark(worker);
            System.out.println("finish watch ... ");
        }
    }

    static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println("worker: " + Thread.currentThread().getState());
            System.out.println("do work ...");
            LockSupport.park();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish work ... ");
        }
    }

}
