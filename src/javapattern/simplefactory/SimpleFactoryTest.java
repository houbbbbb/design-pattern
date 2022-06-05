package javapattern.simplefactory;

import javapattern.util.ConfigUtils;
import org.junit.Test;

/**
 * @author 86136
 */
public class SimpleFactoryTest {

    @Test
    public void test() {

        exc("simple-factory.shape");
    }

    private void exc(
            String name) {

        Shape shape = Shape.getInstance(name);
        shape.drawl();
        shape.erase();
    }
}
