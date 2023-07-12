package org.breeze.design.TemplateMethodPattern.Demo;

/**
 * 测试用例模板
 */
public abstract class TestCase {

    public void run(){
        if(doTest()){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
    }

    public abstract boolean doTest();

}
