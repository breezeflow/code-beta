package org.breeze.concurrency.AQS;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);

        // 第一组api: add remove
        queue.add(1);
        queue.add(2);
        // 如果队满会抛异常
//        queue.add(3);
        queue.remove();
        queue.remove();
        // 如果队空也会抛异常
//        queue.remove();
        System.out.println(queue.size());

        // 第二组api：offer、poll
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        // element 同 peek 都是 返回队列的头元素，不同的是，如果队列为null，element会抛异常，peek 则是返回null
//        System.out.println(queue.element());
        queue.poll();
        queue.poll(5, TimeUnit.SECONDS);
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        // 第三组 api : put take
        // 如果堆满会阻塞
        queue.put(1);
        queue.put(2);
        System.out.println(queue.size());

        // 如果堆空也会阻塞
        queue.take();
        queue.take();
        System.out.println(queue.size());
    }

}
