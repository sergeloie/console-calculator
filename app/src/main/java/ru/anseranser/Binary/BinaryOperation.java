package ru.anseranser.Binary;

public interface BinaryOperation<T> {

    public static final String OPERATION_SIGN = null;
    public static final String REGEX_CHECK = null;
    public static final String REGEX_SPLIT = null;

    static <T extends Number> T Calculate(T a, T b) {
        return null;
    }

    static <T,O extends Number> T createNumber(double value, Class<T> clazz, Class<O> clazz2) {
        if (clazz == Integer.class && clazz2 == Integer.class) {
            return (T) Integer.valueOf((int) value);
        } else if (clazz == Long.class && clazz2 == Long.class) {
            return (T) Long.valueOf((long) value);
        } else {
            return (T) Double.valueOf(value);
        }
    }
}
