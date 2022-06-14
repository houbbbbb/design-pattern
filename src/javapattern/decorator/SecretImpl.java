package javapattern.decorator;

/**
 * @author hbw
 */
public class SecretImpl
        implements Secret {

    @Override
    public String secret(
            String str) {

        return str + " > 普通加密";
    }
}
