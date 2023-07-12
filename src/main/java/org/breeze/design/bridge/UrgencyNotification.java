package org.breeze.design.bridge;

public class UrgencyNotification extends Notification {
    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        // 不同告警级别  处理逻辑不同
        msgSender.send(message);
    }
}
