package javapattern.singleton;

import org.junit.Test;

/**
 * @author 86136
 */
public class SingletonTest {

    @Test
    public void test() {

        LoadBalancer l1 = LoadBalancer.getInstance();
        LoadBalancer l2 = LoadBalancer.getInstance();

        assert l1 == l2;
        assert l1.equals(l2);
    }
}
