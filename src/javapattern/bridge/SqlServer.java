package javapattern.bridge;

/**
 * @author hbw
 */
public class SqlServer
        implements Db {

    @Override
    public String read() {

        return "read from sqlServer";
    }
}
