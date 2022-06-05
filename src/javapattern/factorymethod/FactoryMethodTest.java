package javapattern.factorymethod;

import javapattern.util.ConfigUtils;
import org.junit.Test;

/**
 * @author 86136
 */
public class FactoryMethodTest {

    @Test
    public void test () {

        PictureReaderFactory.getInstance("factory-method.factory")
                .createPicReader()
                .readPicture();
    }
}
