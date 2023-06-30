package org.breeze.base.DesignPattern.BridgePattern;

public class EmailMsgSender implements MsgSender {
    @Override
    public void send(String message) {
        //邮件告警的 逻辑
    }
}
