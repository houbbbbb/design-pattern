package javapattern.bridge;

/**
 * @author hbw
 */
public class Mysql
        implements Db {

    @Override
    public String read() {

        return "read from mysql";
    }
}
