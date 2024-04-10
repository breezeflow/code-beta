package org.breeze.spring.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 
 * 
 */
public class BizEvent extends ApplicationEvent {
    public BizEvent(Object source) {
        super(source);
    }
}
