package org.breeze.concurrency.ThreadSafe.CompleteFuture;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CompletionServiceExample {

    // 假设有100个数，放到集合中，需要处理


    public static void main(String[] args) {
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            target.add(i);
        }

        int availableProcessors = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = new ThreadPoolExecutor(availableProcessors * 2, 40, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10));

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        // 将这批数 分为多批
        List<List<Integer>> parts = Lists.partition(target, 20);

        // 然后 多线程异步处理
        parts.forEach(e -> {
            completionService.submit(() -> e.size());
            System.out.println("异步任务已执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        // 然后取出每个线程的结果
        IntStream.range(0, parts.size()).forEach(i -> {
            try {
                Future<Integer> take = completionService.take();
                System.out.println("第" + i + "批数据的处理结果：" + take.get());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        });
    }


}
