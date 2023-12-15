package org.breeze.concurrency.ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author andy
 */
public class ThreadDemo {

    private static ExecutorService executorService = new ThreadPoolExecutor(2, 10, 10,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory());

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        // 继承 Thead
        Task1 task1 = new Task1();
        task1.start();

        // 实现 Runnable
        Thread task2 = new Thread(new Task2());
        task2.start();

        // Callable 结合 FutureTask
        FutureTask<String> task3 = new FutureTask<>(new Task3());
        new Thread(task3).start();
        System.out.println(task3.get(3, TimeUnit.SECONDS));

        // Callable 结合线程池
        Future<String> task4 = executorService.submit(new Task3());
        System.out.println(task4.get(3, TimeUnit.SECONDS));


    }

    static class Task1 extends Thread {
        @Override
        public void run() {
            System.out.println("do task1 ... ");
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            System.out.println("do task2 ... ");
        }
    }

    static class Task3 implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "do task3 ... ";
        }
    }

}
