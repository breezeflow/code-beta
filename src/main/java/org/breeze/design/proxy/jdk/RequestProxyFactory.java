package org.breeze.design.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 
 * 
 */
public class RequestProxyFactory<T> {

    private Class<T> proxyInterface;

    public RequestProxyFactory(Class<T> proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    public T newInstance() {
        final RequestProxy<T> mapperProxy = new RequestProxy<>(proxyInterface);
        return (T) Proxy.newProxyInstance(proxyInterface.getClassLoader(), new Class[]{proxyInterface}, mapperProxy);
    }

}
