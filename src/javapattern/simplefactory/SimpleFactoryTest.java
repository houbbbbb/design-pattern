package javapattern.simplefactory;

import org.junit.Test;

/**
 * @author 86136
 */
public class SimpleFactoryTest {

    @Test
    public void test() {

        exc(Shape.Type.CIRCLE);

        exc(Shape.Type.SQUARE);

        exc(Shape.Type.TRIANGLE);
    }

    private void exc(Shape.Type type) {

        Shape shape = Shape.getInstance(type);
        shape.drawl();
        shape.erase();
    }
}
