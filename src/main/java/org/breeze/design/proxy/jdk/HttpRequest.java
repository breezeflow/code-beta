package org.breeze.design.proxy.jdk;

import org.breeze.design.proxy.IRequest;

/**
 * @author andy
 * @version 1.0.0
 */
public class HttpRequest implements IRequest {
    @Override
    public String get(String param) {
        return "这是一个 HTTP 请求: param :" + param;
    }
}
