package org.breeze.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author andy
 * @version 1.0.0
 */
public class RequestProxy<T> implements InvocationHandler {

    private Class<T> proxyInterface;

    public RequestProxy(Class<T> proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return "你的被代理了！" + proxyInterface.getName() + "#" + method.getName() + " 参数 : " + args;
        }
    }
}
