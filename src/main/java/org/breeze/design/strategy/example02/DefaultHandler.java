package org.breeze.design.strategy.example02;


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
