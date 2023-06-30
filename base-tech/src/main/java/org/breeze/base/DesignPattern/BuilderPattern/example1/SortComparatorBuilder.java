package org.breeze.base.DesignPattern.BuilderPattern.example1;


public class SortComparatorBuilder<T> implements ComparatorBuilder {

    private SortComparator comparator = new SortComparator<T>();

    @Override
    public SortComparatorBuilder field(String field){
        comparator.setField(field);
        return this;
    }

    @Override
    public SortComparatorBuilder defaultFiled(String defaultFiled){
        comparator.setDefaultField(defaultFiled);
        return this;
    }

    @Override
    public SortComparatorBuilder order(Order order){
        comparator.setOrder(order);
        return this;
    }


    @Override
    public ComparatorBuilder clazz(Class aClass) {
        comparator.setClz(aClass);
        return this;
    }

    @Override
    public SortComparator build(){
        return comparator;
    }

}

