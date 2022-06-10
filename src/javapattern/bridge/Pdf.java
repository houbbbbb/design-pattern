package javapattern.bridge;

/**
 * @author hbw
 */
public class Pdf
        implements Ff {

    @Override
    public void write(
            String data) {

        System.out.println(data + ", write to pdf");
    }
}
