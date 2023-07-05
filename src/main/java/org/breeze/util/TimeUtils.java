package org.breeze.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类：Timestamp String long
 */
public class TimeUtils {

    public final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public final static ZoneOffset zoneOffset = ZoneOffset.of("+8");

    /** 默认格式化，日期加时间 */
    public static final  String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 日期格式化 */
    public static final  String YEAR_MONTH_DAY_FORMAT = "yyyy-MM-dd";
    /** 时间格式化 */
    public static final  String HOUR_MINUTE_SECOND_FORMAT = "HH:mm:ss";

    public static final DateTimeFormatter DEFAULT_DFT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter YEAR_MONTH_DAY_DFT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter HOUR_MINUTE_SECOND_DFT = DateTimeFormatter.ofPattern("HH:mm:ss");

    // 亚洲上海，东八时区
    private static final String ASIA_SHANGHAI = "Asia/Shanghai";

    // 亚洲上海，东八时区，ZoneId实例
    private static final ZoneId ASIA_SHANGHAI_ZONE = ZoneId.of(ASIA_SHANGHAI);

    // 一天的秒数
    public static final Long DAY_SECOND_COUNT = 24 * 60 * 60L ;

    // 一天的毫秒数
    public static Long ONE_DAY_MILLIS = 1000 * 60 * 60 * 24L;

    // 十亿
    private static final Long ONE_BILLION = 1000000000L;

    /**
     * 获取当天的0点时间戳
     * @return 返回毫秒
     */
    public static long getStartDayMillTimestamp(){
        long startDaySec= getStartOfDay();
        return TimeUtils.secondsToMsec(startDaySec);
    }

    /**
     * 获取今天的开始时间戳
     * @return 单位秒
     */
    public static long getStartOfDay() {
        LocalDate date = LocalDate.now();
        return date.atStartOfDay().atZone(ZoneId.of(ASIA_SHANGHAI)).toInstant().toEpochMilli() / 1000;
    }

    /**
     * 将date日期转为时间戳（秒）
     * @param date
     * @return
     */
    public static Long date2Timestamp(Date date){
        Timestamp ts = new Timestamp(date.getTime());
        return getTimestamp(ts.getTime());
    }


    /**
     * 把按毫秒计算的时间戳换成按秒计算的时间戳
     * @param timestamp
     * @return
     */
    public static Long getTimestamp(Long timestamp){
        return timestamp/1000;
    }

    /**
     * 从时间戳转成java.util.Date类
     * @param timestamp
     * @return
     */
    public static Date timestamp2Date(Long timestamp){
        if(timestamp == null){
            return null;
        }
        Date date = new Date(timestamp*1000);
        return date;
    }

    /**
     * 获取当前时间戳
     * @return Long类型，单位秒
     */
    public static Long getCurrentTimestamp() {
        Long timestamp = System.currentTimeMillis() / 1000;
        return timestamp;
    }


    /**
     * 返回当前时间戳，单位毫秒
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 纳秒转化为秒 入参非法：null 则返回 null
     * @param nano
     * @return
     */
    public static Long nanosecondToSecond(Long nano){
        if(nano ==null){
            return null;
        }
        return nano/ONE_BILLION;
    }

    /**
     * 获取今天零点时间戳，单位秒
     */
    public static long getTodayZore() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取今天星期几
     * @param timestampMillis 时间戳，单位毫秒
     * @return int 1周日，2周一，3周二，4周三，5周四，6周五，7周六
     **/
    public static int getDayOfWeek(Long timestampMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timestampMillis));
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 日期格式化
     * @param date
     * @param format
     * @return
     */
    public static String dateFormat(Date date, String format) {
        if (format == null) {
            format = DEFAULT_FORMAT;
        }
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(date);
    }

    public static String date2String(Date date, String sFormat) {

        if (sFormat == null) {
            sFormat = DEFAULT_FORMAT;
        }

        java.text.DateFormat format = new SimpleDateFormat(sFormat);
        return format.format(date);
    }

    /**
     * 秒为单位时间戳转化为毫秒为单位的时间戳
     * @param secondsTimestamp 秒时间戳
     * @return
     */
    public static Long secondsToMsec(Long secondsTimestamp){
        if(secondsTimestamp == null){
            return null;
        }
        return secondsTimestamp * 1000;
    }

    /**
     * 把时间戳（毫秒）转为时间戳（秒）
     * @param millisTimestamp 入参时间戳（毫秒）
     * @return secondsTimestamp 返回时间戳（秒）
     */
    public static Long millis2Seconds(Long millisTimestamp) {
        return  millisTimestamp / 1000;
    }

    /**
     * @param timestamp 毫秒时间戳
     * @date 2019-03-12
     * @return Integer
     * 通过毫秒时间戳获取 第几个月
     */
    public static Integer getMonthByTimestamp(Long timestamp){
        Calendar calendar =  Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        //一月对应0
        //十二月对应11
        Integer month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 通过毫秒时间戳获取 年份
     * @param timestamp
     * @return
     */
    public static Integer getYearByTimestamp(Long timestamp){
        Calendar calendar =  Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        Integer year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取传入时间戳，当天的开始时间（单位毫秒）
     *
     * @param millisecond 时间戳，毫秒
     **/
    public static long getStartOfDayMillisecond(long millisecond) {
        Instant instant = Instant.ofEpochMilli(millisecond);
        return LocalDateTime.ofInstant(instant, ASIA_SHANGHAI_ZONE).toLocalDate().atStartOfDay()
                .atZone(ASIA_SHANGHAI_ZONE).toInstant().toEpochMilli();
    }

    /**
     * 获取今天的开始时间（单位毫秒）
     **/
    public static long getStartOfDayMillisecond() {
        return getStartOfDayMillisecond(System.currentTimeMillis());
    }

    /**
     * 获取指点时间，加减天数后，当天的开始时间（单位毫秒）
     *
     * @param millisecond 时间毫秒
     * @param day         加减天数，正数加，负数减
     **/
    public static long getStartOfDayMillisecondPlusDays(long millisecond, Integer day) {
        day = day == null ? 0 : day;

        Instant instant = Instant.ofEpochMilli(millisecond);

        LocalDate localDate = LocalDateTime.ofInstant(instant, ASIA_SHANGHAI_ZONE).toLocalDate();
        return localDate.plusDays(day).atStartOfDay().atZone(ASIA_SHANGHAI_ZONE).toInstant().toEpochMilli();
    }

    /**
     * 获取当前时间，加减天数后，当天的开始时间（单位毫秒）
     *
     * @param day         加减天数，正数加，负数减
     **/
    public static long getStartOfDayMillisecondPlusDays(Integer day) {
        return getStartOfDayMillisecondPlusDays(System.currentTimeMillis(), day);
    }

    /**
     * 获取指定时间戳所有月的月初1号0点时间戳（毫秒）
     * @param timestamp 时间戳，毫秒
     * @param plusMonth 加减月数
     */
    public static long getFirstDayOfMonth(long timestamp, int plusMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timestamp));
        calendar.add(Calendar.MONTH, plusMonth);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 获取季度的第一天0点时间戳，毫秒
     * @param timestamp 时间戳，毫秒
     * @param plusQuarter 季度偏移
     */
    public static long getFirstDayOfQuarter(long timestamp, int plusQuarter) {
        // 设置当前月份第一天
        LocalDateTime localDateTime = TimeUtils.getLocalDateTime(timestamp).with(TemporalAdjusters.firstDayOfMonth());
        Month month = localDateTime.getMonth();
        if (checkQuarterFirstMonth(month) && plusQuarter == 0) {
            // 转为当前0点时间戳
            return localDateTime.toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        }

        // 设置为当前季度的第一个月
        int difference = calDifferenceBetweenCurrMonthAndQuarterStartMonth(month);
        localDateTime = localDateTime.plusMonths(difference);

        // 处理季度偏移问题
        localDateTime = localDateTime.plusMonths(plusQuarter * 3);
        return localDateTime.toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将时间戳转 年月日 yyyy-MM-dd
     * @param timestampMillis 时间戳毫秒
     */
    public static String timestamp2Date(long timestampMillis){
        LocalDateTime localDateTime = getLocalDateTime(timestampMillis);
        return localDateTime.format(YEAR_MONTH_DAY_DFT);
    }

    /**
     * 将时间戳转 时分秒 HH:mm:ss
     * @param timestampMillis 时间戳毫秒
     */
    public static String timestamp2Time(long timestampMillis){
        LocalDateTime localDateTime = getLocalDateTime(timestampMillis);
        return localDateTime.format(HOUR_MINUTE_SECOND_DFT);
    }

    /**
     * 将时间戳转 年月日 时分秒 yyyy-MM-dd HH:mm:ss
     * @param timestampMillis 时间戳毫秒
     */
    public static String timestamp2DateTime(long timestampMillis){
        LocalDateTime localDateTime = getLocalDateTime(timestampMillis);
        return localDateTime.format(DEFAULT_DFT);
    }

    /**
     * 时间戳毫秒 转 localDateTime 。采用系统默认的时区
     * @param timestamp 时间戳，毫秒
     */
    public static LocalDateTime getLocalDateTime(long timestamp){
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 时间戳毫秒 转 localDate 。采用系统默认的时区
     * @param timestamp 时间戳，毫秒
     */
    public static LocalDate getLocalDate(long timestamp){
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone).toLocalDate();
    }

    /**
     * 将时间字符串按指定格式解析为时间戳，毫秒
     * @param dateTimeStr 时间字符串
     * @param formatterStr 时间字符串格式
     * @return 时间戳，毫秒
     */
    public static long dateTime2Timestamp(String dateTimeStr, String formatterStr) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatterStr);
        LocalDateTime parse = LocalDateTime.parse(dateTimeStr, dtf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将 日期时间字符串（年月日时分秒） 按指定格式解析为时间戳，毫秒
     * @param dateTimeStr 日期时间字符串
     * @param dtf DateTimeFormatter 日期时间字符串格式化实例
     * @return 时间戳，毫秒
     */
    public static long dateTime2Timestamp(String dateTimeStr, DateTimeFormatter dtf){
        LocalDateTime parse = LocalDateTime.parse(dateTimeStr, dtf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将 yyyy-MM-dd HH:mm:ss 时间字符串转为时间戳，毫秒
     * @param dateTimeStr yyyy-MM-dd HH:mm:ss 的时间字符串
     */
    public static long dateTime2Timestamp(String dateTimeStr){
        return dateTime2Timestamp(dateTimeStr, DEFAULT_DFT);
    }

    public static long date2Timestamp(String dateStr, String formatStr){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatStr);
        return date2Timestamp(dateStr, dtf);
    }

    /**
     * 将 日期字符串（年月日） 转为时间戳，毫秒。处理为该日期的0点时间戳
     * @param dateStr yyyy-MM-dd 日期字符串
     * @param dtf DateTimeFormatter 日期字符串格式化实例
     */
    public static long date2Timestamp(String dateStr, DateTimeFormatter dtf){
        LocalDate parse = LocalDate.parse(dateStr, dtf);
        return parse.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将 yyyy-MM-dd 时间字符串转为时间戳，毫秒。处理为该日期的0点时间戳
     * @param dateStr yyyy-MM-dd 的时间字符串
     */
    public static long date2Timestamp(String dateStr){
        return date2Timestamp(dateStr, YEAR_MONTH_DAY_DFT);
    }

    /**
     * 检查是否为季度的第一个月
     * @param month 月份
     */
    public static boolean checkQuarterFirstMonth(Month month) {
        return Month.JANUARY.equals(month) || Month.APRIL.equals(month) ||
                Month.JULY.equals(month) || Month.OCTOBER.equals(month);
    }

    /**
     * 计算 当前月份 和 所在季度第一个月的差值。 差值 = 当前月份 - 当前月份所在季度的第一个月
     * @param month 当前月份
     */
    public static int calDifferenceBetweenCurrMonthAndQuarterStartMonth(Month month) {
        int result;
        if ((result = Month.OCTOBER.getValue() - month.getValue()) <= 0) {
            return result;
        } else if ((result = Month.JULY.getValue() - month.getValue()) <= 0) {
            return result;
        } else if ((result = Month.APRIL.getValue() - month.getValue()) <= 0) {
            return result;
        } else {
            return Month.JANUARY.getValue() - month.getValue();
        }
    }

    /**
     * 获取时间戳（东8区）的年份
     *
     * @param timestampMs 时间戳，单位毫秒
     * @return long 如 2020
     **/
    public static long getYear(long timestampMs) {
        LocalDateTime localDateTime = getLocalDateTime(timestampMs, ZoneOffset.ofHours(8));
        return localDateTime.getYear();
    }

    /**
     * 获取 zoneOffset 时区的 LocalDateTime 实例
     *
     * @param timestampMs 时间戳，单位毫秒
     * @param zoneOffset  时区
     **/
    public static LocalDateTime getLocalDateTime(long timestampMs, ZoneOffset zoneOffset) {
        return LocalDateTime.ofEpochSecond(timestampMs / 1000, (int) (timestampMs % 1000 * 1000000), zoneOffset);
    }

    /**
     * 时间戳加 timestampMs 年
     *
     * @param timestampMs 时间戳，单位毫秒
     * @param year        需要增加的年数
     * @return long 时间戳，毫秒
     **/
    public static long timePlusYear(long timestampMs, int year) {
        LocalDateTime localDateTime = getLocalDateTime(timestampMs, ZoneOffset.ofHours(8));
        return localDateTime.plusYears(year).toEpochSecond(ZoneOffset.ofHours(8)) * 1000L;
    }

    /**
     * 获取当前 时间
     * @return
     */
    public static String now() {
        return LocalDateTime.now().format(formatter);
    }

    public static Integer getDiffDays(LocalDateTime dt1,LocalDateTime dt2){
        //获取第一个时间点的时间戳对应的秒数
        long t1 = dt1.toEpochSecond(ZoneOffset.ofHours(0));
        //获取第一个时间点在是1970年1月1日后的第几天
        long day1 = t1 /(60*60*24);
        //获取第二个时间点的时间戳对应的秒数
        long t2 = dt2.toEpochSecond(ZoneOffset.ofHours(0));
        //获取第二个时间点在是1970年1月1日后的第几天
        long day2 = t2/(60*60*24);
        //返回两个时间点的天数差
        return Math.toIntExact(day2 - day1);
    }


}
