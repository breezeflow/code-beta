package org.breeze.design.proxy;

/**
 * 静态代理，代理类和目标类都要实现共同的接口
 *
 * @author andy
 * @version 1.0.0
 */
public class StaticProxy implements IRequest {

    private IRequest request;

    public StaticProxy(IRequest request) {
        this.request = request;
    }


    @Override
    public String get(String param) {
        return request.get(param);
    }
}
