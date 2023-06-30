package org.breeze.base.DesignPattern.StrategyPattern.example02;


import java.util.ArrayList;
import java.util.List;

public class DefaultHandler extends BaseHandler {
    @Override
    public void execute() {

    }

    @Override
    public List<AsyncTaskTypeEnum> supportTaskType() {
        return new ArrayList<>();
    }
}
