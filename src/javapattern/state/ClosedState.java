package javapattern.state;

/**
 * @author hbw
 */
public class ClosedState
        implements State {

    private ClosedState() {}

    private static final ClosedState O = new ClosedState();

    public static ClosedState getInstance() {

        return O;
    }

    @Override
    public void handle() {

        System.out.println("关闭");
    }
}
