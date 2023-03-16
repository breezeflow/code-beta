package org.breezeflow.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 垃圾回收（GC）示例
 *
 * @author andy
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();

        applicationContext.close();

        Thread.sleep(5000);
        // 强制触发 GC
        System.gc();
        Thread.sleep(5000);
    }
}
