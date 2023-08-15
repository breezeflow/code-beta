package org.breeze.base;

public class TryCatchFinallyExample {

    public static void main(String[] args) {
        TryCatchFinallyExample demo = new TryCatchFinallyExample();
        System.out.println(demo.test());
    }

    public int test() {
        int i = 16;
        try {
            i = i >> 1;
            System.out.println("try : i = " + i);
//            int a  = i/0;
            return i;
        } catch (Exception e) {
            System.out.println("catch块");
            e.printStackTrace();
//            throw new RuntimeException("catch 中抛出了新的异常");
        } finally {
            System.out.println("finally块");
            // try 块 return 之前 ，
            i += 10;
            System.out.println("finally : i = " + i);
            // try 、finally 同时有return时 执行的是finally中的return
//            return i;
        }
        return 0;
    }

}
