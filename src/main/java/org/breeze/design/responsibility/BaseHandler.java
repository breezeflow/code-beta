package org.breeze.design.responsibility;

public abstract class BaseHandler {

    protected BaseHandler handler = null;

    public void setHandler(BaseHandler handler){
        this.handler = handler;
    }

    public void handle(){
        boolean result = doHandle();
        if(handler != null  && result){
            handler.handle();
        }
    }

    protected abstract boolean doHandle();

}
