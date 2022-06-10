package javapattern.bridge;

/**
 * @author hbw
 */
public class Txt
        implements Ff {

    @Override
    public void write(
            String data) {

        System.out.println(data + ", write to txt");
    }
}
