package org.breeze.DesignPattern.StrategyPattern.example02;


import java.util.Arrays;
import java.util.List;

/**
 * 执行消息推送的异步任务
 */
public class SendMessageTaskHandler extends BaseHandler {
    @Override
    public void execute() {
        System.out.println("执行消息推送的异步任务！");
    }

    @Override
    public List<AsyncTaskTypeEnum> supportTaskType() {
        return Arrays.asList(AsyncTaskTypeEnum.SEND_MESSAGE);
    }
}
