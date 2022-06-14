package javapattern.decorator;

/**
 * @author hbw
 */
public class ModSecretDecorator
        implements Secret {

    private final Secret secret;

    public ModSecretDecorator(
            Secret secret) {

        this.secret = secret;
    }

    @Override
    public String secret(
            String str) {

        return secret.secret(str) + " > 求模加密";
    }
}
