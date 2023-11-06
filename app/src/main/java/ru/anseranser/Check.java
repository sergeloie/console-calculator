package ru.anseranser;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    public static boolean isOnlyDigitsAndArithmetic(String str) {
//        String regex1 = "[0-9.+\\-*/()]+";
//        return str.matches(regex1);

        List<String> smallStrings = Arrays.asList("\\+", "\\-", "\\*", "\\/", "\\(", "\\)");
        String pattern = "^(\\d+(\\.\\d+)?|(" + String.join("|", smallStrings) + "))*$"; // Регулярное выражение

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(str);

        return matcher.matches();
    }

    public static boolean isSingleArithmetic(String str) {
        String pattern = "[+\\-*/.]{2,}"; // Регулярное выражение для поиска двух или более знаков операции
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(str);
        return !matcher.find();
    }

    public static boolean isBracketsBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(' -> stack.push(ch);
                case ')'-> {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isSignNearBracket(String str) {
        String pattern = "\\d\\(|\\)\\d";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(str);
        return !matcher.find();
    }
}
