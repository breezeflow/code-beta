package org.breeze.base;

/**
 * 使用枚举实现单例
 */
public enum EnumSingleton {

    INSTANCE;

    public String process(String s) {
        System.out.println(s);
        return "process:".concat(s);
    }
}
