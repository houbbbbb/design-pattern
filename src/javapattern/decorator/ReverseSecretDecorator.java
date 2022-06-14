package javapattern.decorator;

/**
 * @author hbw
 */
public class ReverseSecretDecorator
        implements Secret {

    private final Secret secret;

    public ReverseSecretDecorator(
            Secret secret) {

        this.secret = secret;
    }

    @Override
    public String secret(
            String str) {

        return secret.secret(str) + " > 逆向输出加密";
    }
 }
