package javapattern.proxy;

import org.junit.Test;

/**
 * @author hbw
 */
public class ProxyTest {

    @Test
    public void test() {

        Process process = new ProcessProxy(new ProcessImpl());

        process.method();
    }
}
