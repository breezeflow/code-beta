package org.breeze.design.InterfaceIsolation;

public class KafkaConfig implements Updater {

    private ConfigSource configSource;

    public KafkaConfig(ConfigSource configSource){
        this.configSource = configSource;
    }

    @Override
    public void update() {

    }
}
