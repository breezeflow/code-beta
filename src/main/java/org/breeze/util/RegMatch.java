package org.breeze.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegMatch {

    // 车牌校验
    public final static String CAR_LICENSE_PATTERN = "^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";

    // pivot值校验
    public final static String PIVOT_CHECK_V2 = "^.+=((\\d+)|(\\d*\\.\\d{1,3}))$";

    /**
     * 校验中国车牌
     *
     * @param str
     * @return
     */
    public static boolean matchCarNo(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        str = str.replaceAll(" ", "");
        Pattern pattern = Pattern.compile(CAR_LICENSE_PATTERN);
        Matcher matcher = pattern.matcher(str.trim());
        return matcher.find();
    }

    /**
     * 校验Pivot值：任意字符=任意整数/小数点后最长3位的小数
     *
     * @param str
     * @return
     */
    public static boolean matchPivotValue(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile(PIVOT_CHECK_V2);
        Matcher matcher = pattern.matcher(str.trim());
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(matchCarNo("粤B123456"));
        System.out.println(matchPivotValue("TEST051750623=2500.111"));
    }

}
