package javapattern.factorymethod;

/**
 * @author 86136
 */
public class JpgPictureReader
        implements PictureReader {

    @Override
    public void readPicture() {

        System.out.println("read gpg picture");
    }
}
