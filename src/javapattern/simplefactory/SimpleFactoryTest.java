package javapattern.simplefactory;

import org.junit.Test;

/**
 * @author 86136
 */
public class SimpleFactoryTest {

    @Test
    public void test() {

        exc("circle");

        exc("square");

        exc("triangle");
    }

    private void exc(
            String name) {

        Shape shape = Shape.getInstance(name);
        shape.drawl();
        shape.erase();
    }
}
