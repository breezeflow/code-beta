package org.breeze.base.DesignPattern.BridgePattern;

public class WeChatMsgSender implements MsgSender {
    @Override
    public void send(String message) {
        // 微信告警的逻辑
    }
}
