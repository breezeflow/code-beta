package org.breeze.design.template;

/**
 * 测试用例模板类
 */
public abstract class TestCase {

    /**
     * 模板方法，封装通用逻辑
     */
    public void run() {
        if (doTest()) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
    }

    /**
     * 扩展 自定义逻辑
     *
     * @return
     */
    public abstract boolean doTest();

}
