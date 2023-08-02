package org.breeze.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author andy
 * @version 1.0.0
 */
public class RegMatch {

    public static void main(String[] args) {
        String input = "广东省深圳市长南山区南山大道693号(SOSLQHKF12345#3栋)wo";
        String regex = "(?i)[A-Za-z0-9]{8,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Matched substring: " + match);
        }
    }

}
