package javapattern.state;

/**
 * @author hbw
 */
public class StayOpenState
        implements State {

    private StayOpenState() {}

    private static final StayOpenState O = new StayOpenState();

    public static StayOpenState getInstance() {

        return O;
    }

    @Override
    public void handle() {

        System.out.println("保持打开");
    }
}
