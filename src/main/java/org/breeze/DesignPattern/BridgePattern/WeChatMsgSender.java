package org.breeze.DesignPattern.BridgePattern;

public class WeChatMsgSender implements MsgSender {
    @Override
    public void send(String message) {
        // 微信告警的逻辑
    }
}
