package org.breeze.concurrency.ThreadSafe.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * ConcurrentHashMap 线程安全类
 */

@Slf4j
public class ConcurrrentHashMapExample {

    private static int clientTotal = 5000;

    private static int threadTotal = 200;

    private static Map<Integer, Integer> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            int count = i;
            pool.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception" + e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        pool.shutdown();
        log.info("size:{}", hashMap.size());
    }

    private static void update(int threadNo) {
        hashMap.put(threadNo, threadNo);
    }
}
