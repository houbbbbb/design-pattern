package javapattern.state;

/**
 * @author hbw
 */
public class OpenState
        implements State {

    private OpenState() {}

    private static final OpenState O = new OpenState();

    public static OpenState getInstance() {

        return O;
    }

    @Override
    public void handle() {

        System.out.println("打开");
    }
}
