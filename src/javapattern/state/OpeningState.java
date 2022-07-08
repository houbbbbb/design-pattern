package javapattern.state;

/**
 * @author hbw
 */
public class OpeningState
        implements State {

    private OpeningState() {}

    private static final OpeningState O = new OpeningState();

    public static OpeningState getInstance() {

        return O;
    }

    @Override
    public void handle() {

        System.out.println("正在打开");
    }
}
