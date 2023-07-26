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
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // try 块 return 之前 ，
            i += 10;
            System.out.println("finally : i = " + i);
            // try 、finally 同时有return时 执行的是finally中的return
//            return i;
        }
        return 0;
    }

}
