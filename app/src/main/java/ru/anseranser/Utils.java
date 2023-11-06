package ru.anseranser;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String cleanUp (String str) {
        return StringUtils.deleteWhitespace(str);
    }

    public static List<String> splitArithmeticString(String str) {
        List<String> result = new ArrayList<>();
        List<String> smallStrings = Arrays.asList("\\+", "\\-", "\\*", "\\/", "\\(", "\\)");
        String str_pattern = "\\d+(\\.\\d+)?|" + String.join("|", smallStrings);
        Pattern pattern = Pattern.compile(str_pattern);
//        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?|[()+\\-*/]");
//        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?|\\(|\\)|\\+|\\|-|\\*|/");

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        System.out.println(result);
        return result;
    }

}
