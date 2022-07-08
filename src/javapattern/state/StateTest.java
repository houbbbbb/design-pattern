package javapattern.state;

import org.junit.Test;

/**
 * @author hbw
 */
public class StateTest {

    @Test
    public void test() {

        Context context = new Context();

        context.setState(StateEnum.OPENING);

        context.click();

        context.complete();

        context.timeout();
    }
}
