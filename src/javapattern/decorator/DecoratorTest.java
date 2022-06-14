package javapattern.decorator;

import org.junit.Test;

/**
 * @author hbw
 */
public class DecoratorTest {

    @Test
    public void test() {

        Secret secret = new SecretImpl();

        secret = new ShiftSecretDecorator(secret);

        secret = new ReverseSecretDecorator(secret);

        secret = new ModSecretDecorator(secret);

        String re = secret.secret("hello");

        System.out.println(re);
    }

    @Test
    public void test1() {

        Secret secret = new SecretImpl();

        secret = new ModSecretDecorator(secret);

        secret = new ShiftSecretDecorator(secret);

        secret = new ReverseSecretDecorator(secret);

        String re = secret.secret("hello");

        System.out.println(re);
    }
}
