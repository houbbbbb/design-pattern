package javapattern.abstractfactory;

import javapattern.util.ConfigUtils;
import org.junit.Test;

/**
 * @author 86136
 */
public class AbstractFactoryTest {

    @Test
    public void test() {

        ControllerFactory factory = ControllerFactory
                .getInstance("abstract-factory.factory");

        factory.createInterfaceController().control();
        factory.createOperationController().control();
    }
}
