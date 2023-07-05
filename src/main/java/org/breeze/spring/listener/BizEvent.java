package org.breeze.spring.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author chenh/S26377
 * @version 2023/07/05
 */
public class BizEvent extends ApplicationEvent {
    public BizEvent(Object source) {
        super(source);
    }
}
