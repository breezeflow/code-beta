package org.breeze.design.InterfaceIsolation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 热更新 功能实现
 */
public class ScheduledUpdater {

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private long initialDelayInSeconds;
    private long periodInSeconds;
    private Updater updater;
    public ScheduledUpdater(Updater updater, long initialDelayInSeconds, long periodInSeconds) {
        this.updater = updater;
        this.initialDelayInSeconds = initialDelayInSeconds;
        this.periodInSeconds = periodInSeconds;
    }
    public void run() {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override public void run() {
                updater.update();
            } }, this.initialDelayInSeconds, this.periodInSeconds, TimeUnit.SECONDS); }

}
