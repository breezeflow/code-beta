package org.breeze.design.proxy;

import org.breeze.design.proxy.jdk.RequestProxyFactory;

/**
 * 
 * 
 */
public class TestProxy {

    public static void main(String[] args) {
        jdkProxy();
    }

    public static void staticProxy() {
        RpcRequest request = new RpcRequest();
        StaticProxy staticProxy = new StaticProxy(request);
        System.out.println(staticProxy.get("rpc"));
    }

    public static void jdkProxy() {
        RequestProxyFactory factory = new RequestProxyFactory(IRequest.class);
        IRequest o = (IRequest) factory.newInstance();
        System.out.println(o.get("test"));
    }

}
