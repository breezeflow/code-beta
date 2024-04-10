package org.breeze.base;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * 
 */
public class FuncInterfaceExample {

    public static void main(String[] args) {

        // 第一种创建方式
        FuncInterface funcInterface = new FuncInterface() {
            @Override
            public void abstractMethod() {
                System.out.println("functional method");
            }
        };

        // 可以隐式转换成 lambda 表达式
        FuncInterface funcInterface1 = () -> System.out.println("functional method");

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);


//         JDK自带的 函数式接口，规范：T 代表参数类型，R 返回类型
        Function<Integer, Integer> function = item -> item * item;
        Consumer<Integer> consumer = item -> {
            if (item % 2 == 0) {
                System.out.println("偶数");
            } else {
                System.out.println("奇数");
            }
        };
        Predicate<Integer> predicate = item -> item % 2 == 0;


        List<Integer> collect = data.stream().map(function).collect(Collectors.toList());
        data.forEach(consumer);
        List<Integer> filtered = data.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(filtered);


        // JDK8后 Runnable 也是函数式接口了，只有 一个抽象方法run没有参数和返回值。
        System.out.println("主线程  当前线程id =" + Thread.currentThread().getId() + "  当前线程名name = " + Thread.currentThread().getName());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("启动了一个线程    当前线程id = " + Thread.currentThread().getId() + "  当前线程名name = " + Thread.currentThread().getName());
            }
        }, "test-1");
        thread.start();

    }

}
