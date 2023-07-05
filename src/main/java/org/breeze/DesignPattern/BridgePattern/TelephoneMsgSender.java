package org.breeze.DesignPattern.BridgePattern;

import java.util.List;

public class TelephoneMsgSender implements MsgSender {

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones){
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        //电话告警 的 逻辑
    }
}
