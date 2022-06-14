package javapattern.decorator;

/**
 * @author hbw
 */
public interface Secret {


    /**
     * 加密
     * @param str
     * @return
     */
    String secret(
            String str);
}
