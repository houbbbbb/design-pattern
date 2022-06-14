package javapattern.decorator;

/**
 * @author hbw
 */
public class ShiftSecretDecorator
        implements Secret {

    private final Secret secret;

    public ShiftSecretDecorator(
            Secret secret) {

        this.secret = secret;
    }

    @Override
    public String secret(
            String str) {

        return secret.secret(str) + " > 移位加密";
    }
}
