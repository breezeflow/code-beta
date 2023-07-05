package org.breeze.DesignPattern.StrategyPattern.example02;


import java.util.Arrays;
import java.util.List;

/**
 * 同步数据到 ES 引擎
 */
public class AsyncDataToEsTaskHandler extends BaseHandler {
    @Override
    public void execute() {
        System.out.println("执行同步数据到ES的异步任务！");
    }

    @Override
    public List<AsyncTaskTypeEnum> supportTaskType() {
        return Arrays.asList(AsyncTaskTypeEnum.ASYNC_DATA_TO_ES);
    }
}
