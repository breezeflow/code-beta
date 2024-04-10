package org.breeze.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegMatch {

    // 车牌校验正则表达式
    public final static String CAR_LICENSE_PATTERN = "^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";


    public final static String PIVOT_CHECK_V2 = "^.+=((\\d+)|(\\d*\\.\\d{1,3}))$";

    public static boolean validCarLicense(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        str = str.replaceAll(" ", "");
        Pattern pattern = Pattern.compile(CAR_LICENSE_PATTERN);
        Matcher matcher = pattern.matcher(str.trim());
        return matcher.find();
    }

    public static boolean match(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile(PIVOT_CHECK_V2);
        Matcher matcher = pattern.matcher(str.trim());
        return matcher.matches();
    }

    public static void testCar() {
//        Arrays.asList("川A123AB", "川A2222学", "川AF12345", "川A12345D",
//                "川A123456", "川A2222i", "川AA12345", "川AD123456").forEach(e -> {
//            if (validCarLicense(e)) {
//                System.out.println(e);
//            }
//        });
        System.out.println(validCarLicense("粤B12345"));
    }

    public static void main(String[] args) {
//        testCar();
        System.out.println(match("TEST051750623=2500.111"));
    }

}
