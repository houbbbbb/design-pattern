package javapattern.bridge;

import javapattern.util.BeanUtils;
import javapattern.util.ConfigUtils;
import javapattern.util.XMLUtils;
import org.junit.Test;

/**
 * @author hbw
 */
public class BridgeTest {

    @Test
    public void test() {

        Converter converter = Bridge.getConverter("bridge.converter");

        converter
                .setDb(Bridge.getDb("bridge.db"))
                .setFf(Bridge.getFf("bridge.ff"))
                .convert();
    }
}
