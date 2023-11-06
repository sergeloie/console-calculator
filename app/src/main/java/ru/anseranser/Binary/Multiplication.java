package ru.anseranser.Binary;

public class Multiplication {

    public static final String OPERATION_SIGN = "*";
    public static final String REGEX_CHECK = "\\*";
    public static final String REGEX_SPLIT = "\\*";

    public static <T extends Number> T Calculate(T number1, T number2) {
        double result = number1.doubleValue() * number2.doubleValue();
        return (T) BinaryOperation.createNumber(result, number1.getClass(), number2.getClass());
//        if (number1 instanceof Integer && number2 instanceof Integer) {
//            return (T) Integer.valueOf((int) result);
//        } else if (number1 instanceof Long && number2 instanceof Long) {
//            return (T) Long.valueOf((long) result);
//        } else {
//            return (T) Double.valueOf(result);
//        }
    }
}
