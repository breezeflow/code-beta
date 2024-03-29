package org.breeze.concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample {


    private final  static int threadCount =200;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        //只允许20个线程并发访问，多余线程会被阻塞
        final Semaphore semaphore = new Semaphore(20);

        for(int i = 0; i< threadCount ; i++){
            final int threadNum = i;
            exec.execute(()->{
                try {
                    semaphore.acquire();//获取一个许可
                    test(threadNum);
                    semaphore.release();//释放许可
                } catch (Exception e) {
                    log.error("exception:",e);
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
