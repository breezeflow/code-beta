package org.breeze.base.DesignPattern.BuilderPattern.example1;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
public class SortComparator<T> implements Comparator<T> {

    private String field;

    private Order order= Order.desc;

    private String defaultField;

    private Class<T> clz;

    @Override
    public int compare(T o1, T o2) {
        Function<T,Comparable> sortFunc = getSortFunc(field);

        if (sortFunc == null ) {
            sortFunc = getSortFunc(defaultField);
        }
        int result = sortFunc.apply(o1).compareTo(sortFunc.apply(o2));
        return order.equals(Order.asc) ? result : result*-1;
    }

    private Function<T,Comparable> getSortFunc(String sort) {
        Method[] methods = clz.getMethods();
        Optional<Method> matchMethod = Stream.of(methods).filter(method -> method.getName().toLowerCase().equals("get" + sort.toLowerCase())).findFirst();

        if (matchMethod.isPresent()) {
            Method method = matchMethod.get();
            return e -> {
                try {
                    return (Comparable) method.invoke(e);
                } catch (IllegalAccessException | InvocationTargetException e1) {
                    e1.printStackTrace();
                }
                return null;
            };
        }
        return null;
    }


    public  Function<T,Comparable> getNullFunc(){
        Method[] methods = clz.getMethods();
        Optional<Method> matchMethod = Stream.of(methods).filter(method -> method.getName().toLowerCase().equals("get" + field.toLowerCase())).findFirst();

        if (matchMethod.isPresent()) {
            Method method = matchMethod.get();
            return e -> {
                try {
                    return Objects.isNull(method.invoke(e));
                } catch (IllegalAccessException | InvocationTargetException e1) {
                    return false;
                }
            };
        }
        return null;
    }
}
