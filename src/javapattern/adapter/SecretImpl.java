package javapattern.adapter;

/**
 * @author 86136
 */
public class SecretImpl
        implements Secret {

    @Override
    public String encode(String str) {

        return "加密(" + str + ")";
    }
}
