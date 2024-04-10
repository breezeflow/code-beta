package org.breeze.concurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class CompletableFutureExample {

    private static ExecutorService executorService = new ThreadPoolExecutor(0, 10, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50));


    public static void main(String[] args) {

//        base();


    }


    private static void baseUsage() {
        // 1. 使用runAsync或supplyAsync发起异步调用
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "cf1");

        // 2. 直接创建一个已完成状态的CompletableFuture
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("cf2");

        // 3. 先初始化一个未完成的CompletableFuture，然后通过complete()、completeExceptionally()，完成该CompletableFuture
        CompletableFuture<String> cf3 = new CompletableFuture<>();
        cf3.complete("success");

        // 4. 一元依赖：cf4 依赖 cf1
        CompletableFuture<String> cf4 = cf1.thenApply(result1 -> {
            //result1为CF1的结果
            //......
            return "cf4";
        });

        // 5. 二元依赖：cf5 同时依赖  cf1 和 cf2 的结果
        CompletableFuture<String> cf5 = cf1.thenCombine(cf2, (result1, result2) -> {
            //result1和result2分别为cf1和cf2的结果
            return "cf5";
        });

        // 6. 多元依赖：cf6 依赖 cf3,cf4,cf5 的结果
        // 多元依赖可以通过allOf或anyOf方法来实现，
        // 区别是当需要多个依赖全部完成时使用allOf，当多个依赖中的任意一个完成即可时使用anyOf
        CompletableFuture<Void> cf6 = CompletableFuture.allOf(cf3, cf4, cf5);
        CompletableFuture<String> result = cf6.thenApply(v -> {
            //这里的join并不会阻塞，因为传给thenApply的函数是在CF3、CF4、CF5全部完成时，才会执行 。
            String result3 = cf3.join();
            String result4 = cf4.join();
            String result5 = cf5.join();
            //根据result3、result4、result5组装最终result;
            return "cf6";
        });
    }


}
