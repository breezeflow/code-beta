package org.breeze.DesignPattern.InterfaceIsolation;

/**
 * 我们设计了两个功能非常单一的接口：Updater 和 Viewer。
 * ScheduledUpdater 只依赖 Updater 这个跟热更新相关的接口，不需要被强迫去依赖不需要的 Viewer 接口，满足接口隔离原则。
 * 同理，SimpleHttpServer 只依赖跟查看信息相关的 Viewer 接口，不依赖不需要的 Updater 接口，也满足接口隔离原则
 */
public class Application {

    public static ConfigSource configSource = new ZookeeperConfigSource(/*省略参数*/);

    public static final RedisConfig redisConfig = new RedisConfig(configSource);
    public static final KafkaConfig kafkaConfig = new KafkaConfig(configSource);
    public static final MySQLConfig mysqlConfig = new MySQLConfig(configSource);
        public static void main(String[] args) {
            ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig, 300, 300);
            redisConfigUpdater.run();
            ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig, 60, 60);
            kafkaConfigUpdater.run();

            SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1", 2389);
            simpleHttpServer.addViewers("/config", redisConfig);
            simpleHttpServer.addViewers("/config", mysqlConfig); simpleHttpServer.run();

        }
}
