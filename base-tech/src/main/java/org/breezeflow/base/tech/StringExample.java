package org.breezeflow.base.tech;

/**
 * @author andy
 * @version 2023/03/28
 */
public class StringExample {
    public static void main(String[] args) {
        String a = new String("aaa");
        String b = new String("aaa");
        String c = a.intern();
        String d = b.intern();
        String e = "bbb";
        String f = "bbb";
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // true
        System.out.println(a == c); // false 一个是字符串池中"aaa"的引用，一个是堆中对象"aaa"的引用
        System.out.println(c == d); // true 都取的字符串池中的 "aaa"的引用
        System.out.println(e == f); // true
    }
}
