package org.breeze.spring.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author andy
 * @version 2023/07/05
 */
public class BizEvent extends ApplicationEvent {
    public BizEvent(Object source) {
        super(source);
    }
}
