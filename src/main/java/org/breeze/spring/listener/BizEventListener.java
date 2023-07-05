package org.breeze.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author andy
 * @version 2023/07/05
 */
@Component
public class BizEventListener implements ApplicationListener<BizEvent> {
    @Override
    public void onApplicationEvent(BizEvent bizEvent) {
        System.out.println("监听到自定义业务事件: " + bizEvent.getSource());
    }
}
