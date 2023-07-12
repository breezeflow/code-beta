package org.breeze.design.builder.example1;


public interface ComparatorBuilder<T>{

    SortComparator<T> build();

    ComparatorBuilder<T> defaultFiled(String code);

    ComparatorBuilder<T> field(String sort);

    ComparatorBuilder<T> order(Order order);

    ComparatorBuilder<T> clazz(Class<T> tClass);

}
