package javapattern.state;

/**
 * @author hbw
 */
public class ClosingState
        implements State {

    private ClosingState() {}

    private static final ClosingState O = new ClosingState();

    public static ClosingState getInstance() {

        return O;
    }

    @Override
    public void handle() {

        System.out.println("正在关闭");
    }
}
