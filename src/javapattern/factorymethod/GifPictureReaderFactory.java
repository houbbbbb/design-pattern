package javapattern.factorymethod;

/**
 * @author 86136
 */
public class GifPictureReaderFactory
        implements PictureReaderFactory {

    @Override
    public PictureReader createPicReader() {

        return new GifPictureReader();
    }
}
