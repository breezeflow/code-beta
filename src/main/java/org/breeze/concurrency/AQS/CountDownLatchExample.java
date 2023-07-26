package org.breeze.concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *   CountDownLatch  能够使一个线程等待其他线程完成各自的工作后再执行
 */
@Slf4j
public class CountDownLatchExample {

    private final  static int threadCount =20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch count = new CountDownLatch(threadCount);

        for(int i = 0; i< threadCount ; i++){
            final int threadNum = i;
            exec.execute(()->{
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception:",e);
                }finally {
                    count.countDown();
                }
            });
        }
//        count.await();//该方法会阻塞所有线程  当执行countDown方法使得 countDownLatch减到0时再执行后面代码
        count.await(1, TimeUnit.SECONDS);//支持给定时间的等待，超过这个时间就不再等待
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception{
            Thread.sleep(3000);
            log.info("{}",threadNum);
    }
}
