package org.breeze.base.DesignPattern.BridgePattern;

public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender){
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);

}
