package org.breeze.concurrency.ThreadPool;

/**
 * @author andy
 */
public class ThreadStatusDemo {

    public static void main(String[] args) throws InterruptedException {

        ThreadStatusDemo demo = new ThreadStatusDemo();

        Thread worker = new Thread(new Work());
        worker.start();

        System.out.println("worker: " + worker.getState());

        Thread watcher = new Thread(new Watch());

        synchronized (worker) {
            worker.wait();
            System.out.println("worker: " + worker.getState());
        }

        demo.notifyAll();

        System.out.println("worker: " + worker.getState());

        while (true){

        }

    }

    static class Watch implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("watch worker ... ");
        }
    }

    static class Work implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do work ... ");
        }
    }

}
