package org.breeze.design.bridge;

public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender){
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);

}
