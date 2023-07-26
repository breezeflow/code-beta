package org.breeze.concurrency.AQS;

import lombok.SneakyThrows;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue();


        System.out.println(queue.offer(1));
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    System.out.println("waiting to produce  .......");
                    queue.put(1);
                    i++;
                    System.out.println("生产了一个新元素，总共生产了=" + i + "个");
                    Thread.sleep(3000);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    System.out.println("waiting to consumer .......");
                    queue.take();
                    i++;
                    System.out.println("消费了一个新元素，总共消费了=" + i + "个");
                    Thread.sleep(5000);
                }
            }
        }).start();
    }


}
