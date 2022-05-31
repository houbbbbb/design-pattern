package javapattern.simplefactory;

import javapattern.util.ConfigUtils;
import org.junit.Test;

/**
 * @author 86136
 */
public class SimpleFactoryTest {

    @Test
    public void test() {

        exc(ConfigUtils.getProp("simple-factory.shape"));
    }

    private void exc(
            String name) {

        Shape shape = Shape.getInstance(name);
        shape.drawl();
        shape.erase();
    }
}
