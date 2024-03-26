package org.breeze.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author andy
 * @version 1.0.0
 */
public class RegMatch {

    // 车牌校验正则表达式
    public final static String CAR_LICENSE_PATTERN = "^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";

    public static boolean validCarLicense(String str) {
        Pattern pattern = Pattern.compile(CAR_LICENSE_PATTERN);
        Matcher matcher = pattern.matcher(str.trim());
        return matcher.find();
    }

    public static void testCar() {
        Arrays.asList("川A123AB", "川A2222学", "川AF12345", "川A12345D",
                "川A123456", "川A2222i", "川AA12345", "川AD123456").forEach(e -> {
            if (validCarLicense(e)) {
                System.out.println(e);
            }
        });
    }

    public static void main(String[] args) {
        testCar();
    }

}
