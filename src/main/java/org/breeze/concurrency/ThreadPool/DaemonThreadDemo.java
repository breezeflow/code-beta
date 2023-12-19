package org.breeze.concurrency.ThreadPool;

/**
 * 守护线程
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("do task1 ... ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("finish task1 ... ");
        }, "task1").start();
        new Thread(() -> {
            System.out.println("do task2 ... ");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("finish task2 ... ");
        }, "task2").start();

        Thread daemonTask = new Thread(() -> {
            System.out.println("isDaemon:" + Thread.currentThread().isDaemon()
                    + ",name:" + Thread.currentThread().getName());

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("finish daemon task");
        }, "daemonTask");
        daemonTask.setDaemon(true);
        daemonTask.start();
        
    }
}
