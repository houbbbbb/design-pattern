package javapattern.factorymethod;

/**
 * @author 86136
 */
public class JpgPictureReaderFactory
        implements PictureReaderFactory {

    @Override
    public PictureReader createPicReader() {

        return new JpgPictureReader();
    }
}
