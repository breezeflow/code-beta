package org.breeze.concurrency.ThreadSafe.PublicObject;

import lombok.extern.slf4j.Slf4j;

/**
 * 对象逸出
 * 在对象未完成 构造之前不可将其发布
 */
@Slf4j
public class EscapeObject {

    private int number = 5;

    public EscapeObject() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", EscapeObject.this.number);
        }
    }

    public static void main(String[] args) {
        new EscapeObject();
    }
}
