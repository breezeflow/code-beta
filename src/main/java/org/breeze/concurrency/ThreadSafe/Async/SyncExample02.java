package org.breeze.concurrency.ThreadSafe.Async;

public class SyncExample02 {

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread("t1");



    }

    static class Task {
        public void task(String code) throws InterruptedException {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "    " + code);
        }
    }


}
