package org.breeze.design.proxy;

/**
 * 需要被代理的类
 *
 * @author andy
 * @version 1.0.0
 */
public class RpcRequest implements IRequest {

    @Override
    public String get(String param) {
        return "这是一个 RPC 请求: param :" + param;
    }

}
