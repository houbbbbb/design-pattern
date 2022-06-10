package javapattern.bridge;

/**
 * @author hbw
 */
public class Oracle
        implements Db {

    @Override
    public String read() {

        return "read from oracle";
    }
}
