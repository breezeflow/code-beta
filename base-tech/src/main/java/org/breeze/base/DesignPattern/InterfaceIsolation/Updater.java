package org.breeze.base.DesignPattern.InterfaceIsolation;

/**
 * 热更新 功能接口:
 * 配置中心中更改了配置信息，我们希望在不用重启系统的情况下，能将最新的配置信息加载到内存中（也就是 RedisConfig、KafkaConfig 类中）
 */
public interface Updater {

    void update();

}
