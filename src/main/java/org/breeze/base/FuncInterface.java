package org.breeze.base;

/**
 * <p>函数式接口</p>
 * <ol>
 *     <li>有且仅有一个抽象方法的</li>
 *     <li>可以存在多个非抽象方法</li>
 *     <li>默认方法不是抽象方法</li>
 * </ol>
 */
@FunctionalInterface
public interface FuncInterface {

    // 抽象方法，函数式接口中有且仅有一个
    void abstractMethod();

    // default 修饰的默认方法，不是抽象方法
    default String defaultMethod() {
        return "default method";
    }

    // 静态方法 不是抽象方法
    static String staticMethod() {
        return "static method";
    }

}
