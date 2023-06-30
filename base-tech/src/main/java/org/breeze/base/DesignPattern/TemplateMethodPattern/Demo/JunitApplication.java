package org.breeze.base.DesignPattern.TemplateMethodPattern.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 单元测试程序
 */
public class JunitApplication {

    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase){
        testCases.add(testCase);
    }

    public static void main(String[] args) {

        register(new BusinessOne());
        register(new BusinessTwo());

        for(TestCase each: testCases){
            each.run();
        }
    }

}
