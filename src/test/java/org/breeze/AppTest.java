package org.breeze;

import org.breeze.base.EnumSingleton;
import org.junit.Test;


public class AppTest {

    @Test
    public void test() {
        System.out.println(EnumSingleton.INSTANCE.process("zhang"));
    }

}
