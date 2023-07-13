package org.breeze.spring.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author andy
 * @version 1.0.0
 */
public class BizEvent extends ApplicationEvent {
    public BizEvent(Object source) {
        super(source);
    }
}
