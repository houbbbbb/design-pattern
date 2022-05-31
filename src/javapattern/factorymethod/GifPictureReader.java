package javapattern.factorymethod;

/**
 * @author 86136
 */
public class GifPictureReader
        implements PictureReader {

    @Override
    public void readPicture() {

        System.out.println("read gif picture");
    }
}
