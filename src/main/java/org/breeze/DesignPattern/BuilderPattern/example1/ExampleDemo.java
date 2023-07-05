package org.breeze.DesignPattern.BuilderPattern.example1;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleDemo {

    public static void main(String[] args) {

        StockKLine kLine = new StockKLine();
        kLine.setTradingDay(1608480000L);
        kLine.setOpenPrice(BigDecimal.valueOf(295));
        kLine.setHighPrice(BigDecimal.valueOf(320));
        kLine.setLowPrice(BigDecimal.valueOf(280));
        kLine.setClosePrice(BigDecimal.valueOf(300));
        kLine.setPreClosePrice(BigDecimal.valueOf(300));
        kLine.setNetChangeValue(BigDecimal.valueOf(100000000));
        kLine.setNetChangeRatio(BigDecimal.valueOf(0.10));
        kLine.setTurnoverVolume(BigDecimal.valueOf(10000));
        kLine.setTurnoverValue(BigDecimal.valueOf(2365600000L));
        kLine.setTurnoverRate(BigDecimal.valueOf(0.0020));
        kLine.setPe(BigDecimal.valueOf(53.378));

        StockKLine kLine2 = new StockKLine();
        kLine2.setTradingDay(1608393600L);
        kLine2.setOpenPrice(BigDecimal.valueOf(290));
        kLine2.setHighPrice(BigDecimal.valueOf(300));
        kLine2.setLowPrice(BigDecimal.valueOf(245));
        kLine2.setClosePrice(BigDecimal.valueOf(280));
        kLine2.setPreClosePrice(BigDecimal.valueOf(255));
        kLine2.setNetChangeValue(BigDecimal.valueOf(200000000));
        kLine2.setNetChangeRatio(BigDecimal.valueOf(0.20));
        kLine2.setTurnoverVolume(BigDecimal.valueOf(20000));
        kLine2.setTurnoverValue(BigDecimal.valueOf(2323600000L));
        kLine2.setTurnoverRate(BigDecimal.valueOf(0.0020));
        kLine2.setPe(BigDecimal.valueOf(51.378));

        List<StockKLine> data = Arrays.asList(kLine,kLine2);
        List<StockKLine> sorted = sort(data, "openPrice", Order.asc);

    }

    public static <T> List<T> sort(Collection<T> origin, String sort, Order order) {

        Class<?> aClass = origin.iterator().next().getClass();
        SortComparator<T> comparator = new SortComparatorBuilder().defaultFiled("code").field(sort).order(order).clazz(aClass).build();

        Map<Object, List<T>> stockMap = origin.stream().collect(Collectors.groupingBy(code -> {
            Function<T, Comparable> nullFunc = comparator.getNullFunc();
            return nullFunc.apply(code);
        }));

        //正常数据按给定字段排序
        return stockMap.getOrDefault(false, Collections.emptyList()).stream().sorted(comparator).collect(Collectors.toList());
    }

}

/**
 * 股票Kline 基本信息
 */
@Data
class StockKLine{

    // 交易日
    private Long tradingDay;

    //开盘价
    private BigDecimal openPrice;

    // 最高价
    private BigDecimal highPrice;

    // 最低价
    private BigDecimal lowPrice;

    // 昨收
    private BigDecimal preClosePrice;

    // 收盘价
    private BigDecimal closePrice;

    // 涨跌额
    private BigDecimal netChangeValue;

    // 涨跌幅
    private BigDecimal netChangeRatio;

    // 成交额
    private BigDecimal turnoverValue;

    // 成交量
    private BigDecimal turnoverVolume;

    //换手率
    private BigDecimal turnoverRate;

    // 市盈率
    private BigDecimal pe;
}
