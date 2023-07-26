package org.breeze.concurrency.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS  -  compare and swap 比较交换 ，基于unsafe 类中的本地方法 实现的
 */
public class CASDemo
{
    public static void main(String[] args)
    {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.get());


        System.out.println(atomicInteger.compareAndSet(5, 308)+"\t"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 3333)+"\t"+atomicInteger.get());
    }
}
