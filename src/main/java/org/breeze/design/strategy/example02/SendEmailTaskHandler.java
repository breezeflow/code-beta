package org.breeze.design.strategy.example02;


import java.util.Arrays;
import java.util.List;

/**
 * 发送邮件的异步任务
 */
public class SendEmailTaskHandler extends BaseHandler {

        @Override
        public void execute() {
            System.out.println("执行发送邮件的异步任务！");
        }

    @Override
    public List<AsyncTaskTypeEnum> supportTaskType() {
        return Arrays.asList(AsyncTaskTypeEnum.SEND_EMAIL);
    }
}
