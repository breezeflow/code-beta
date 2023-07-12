package org.breeze.design.AdapterPattern.case1;

public class CDAdaptor extends CD implements ITarget {
    @Override
    public void function1() {
        staticFunction();
    }

    @Override
    public void function2() {
        super.lowPerformanceFunction();
    }

    @Override
    public void function3() {
        super.uglyNamingFunction();
    }

    @Override
    public void function4() {
        super.tooManyParamsFunction();
    }
}
