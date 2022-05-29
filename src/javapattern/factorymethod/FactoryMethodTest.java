package javapattern.factorymethod;

import org.junit.Test;

/**
 * @author 86136
 */
public class FactoryMethodTest {

    @Test
    public void test () {

        GifPictureReaderFactory gifPictureReaderFactory =
                new GifPictureReaderFactory();
        PictureReader pictureReader =
                gifPictureReaderFactory.createPicReader();

    }
}
