package org.breeze.concurrency.ThreadSafe.SyncContainer;


import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 线程安全方法：Collections.synchronizedSet
 */
@Slf4j
public class CollectionsExample2 {

    private static int clientTotal = 5000;

    private static int threadTotal = 200;

    private static Set<Integer> set = Collections.synchronizedSet(Sets.newHashSet());

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
        log.info("size:{}", set.size());
    }

    private static void update(int count) {
        set.add(count);
    }
}
