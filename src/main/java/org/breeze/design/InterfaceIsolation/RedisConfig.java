package org.breeze.design.InterfaceIsolation;

import java.util.Map;

public class RedisConfig implements Updater,Viewer{
    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;
    //省略其他配置: maxWaitMillis,maxIdle,minIdle...
    public RedisConfig(ConfigSource configSource) { this.configSource = configSource; }
    public String getAddress() { return this.address; }
    //...省略其他get()、init()方法...
    public void update() {
        //从configSource加载配置到address/timeout/maxTotal...
    }

    @Override
    public String outputInPlainText() {
        //省略 相关 显示配置逻辑
        return null;
    }

    @Override
    public Map<String, String> output() {
        // 省略相关 配置输出逻辑
        return null;
    }
}
