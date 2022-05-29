package javapattern.util;

/**
 * @author 86136
 */
public class BeanUtils {

    public static <T> T getBean(String name) {

        return (T)TryUtils.re(() -> Class.forName(name).newInstance());
    }
}
