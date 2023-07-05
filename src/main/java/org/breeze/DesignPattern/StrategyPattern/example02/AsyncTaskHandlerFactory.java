package org.breeze.DesignPattern.StrategyPattern.example02;


import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 异步任务 handler 工厂类
 */
public class AsyncTaskHandlerFactory {

    private Map<AsyncTaskTypeEnum, BaseHandler> baseHandlerMap = new HashMap<>();

    DefaultHandler defaultHandler;

    @PostConstruct
    public void init() {
        //获取 所有 的 异步任务 Handler
//        Map<String,BaseHandler> handlerMap = applicationContext.getBeansOfType(BaseHandler.class);
        Map<String, BaseHandler> handlerMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(handlerMap)) {
            for (BaseHandler baseHandler : handlerMap.values()) {
                List<AsyncTaskTypeEnum> supportTaskType = baseHandler.supportTaskType();
                if (!CollectionUtils.isEmpty(supportTaskType)) {
                    supportTaskType.stream().forEach(asyncTaskTypeEnum -> baseHandlerMap.put(asyncTaskTypeEnum, baseHandler));
                }
            }
        }
    }

    /**
     * 根据 任务类型代码 获取任务
     */
    public BaseHandler getTaskByCode(String tastTypeCode) {
        AsyncTaskTypeEnum taskTypeEnum = AsyncTaskTypeEnum.getByCode(tastTypeCode);
        BaseHandler baseHandler = baseHandlerMap.get(taskTypeEnum);
        if (baseHandler != null) {
            return baseHandler;
        }
        return defaultHandler;
    }


}
