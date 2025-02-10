package org.breeze.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {

    /**
     * 校验规则
     *
     * @param regex 正则表达式
     * @param str   需校验的字符串
     * @return 校验结果 true/false
     */
    public static boolean match(String regex, String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str.trim());
        return matcher.matches();
    }

}
