package org.breeze.base;

/**
 * 
 * 
 */
public class IntegerExample {

    public static void main(String[] args) {
        Integer a = 123;
        Integer b = 123;
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        Integer m = Integer.valueOf(123);
        Integer n = Integer.valueOf(123);
        Integer r = 128;
        Integer s = Integer.valueOf(128);

        System.out.println(a == b); // true
        System.out.println(a == x); // false
        System.out.println(a == m); // true
        System.out.println(x == y); // false
        System.out.println(x == m); // false
        System.out.println(m == n); // true
        System.out.println(r == s); // false
    }
}
