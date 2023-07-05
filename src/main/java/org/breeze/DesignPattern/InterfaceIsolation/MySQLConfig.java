package org.breeze.DesignPattern.InterfaceIsolation;

import java.util.Map;

public class MySQLConfig  implements  Viewer{
    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;
    //省略其他配置: maxWaitMillis,maxIdle,minIdle...
    public MySQLConfig(ConfigSource configSource) { this.configSource = configSource; }
    public String getAddress() { return this.address; }
    //...省略其他get()、init()方法...

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
