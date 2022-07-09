package javapattern.strategy;

import org.junit.Test;

/**
 * @author hbw
 */
public class StrategyTest {

    @Test
    public void test() {

        Context context = new Context();

        context.setPlane(new HeliPlane());

        context.opt();

        context.setPlane(new AirPlane());

        context.opt();

        context.setPlane(new Fighter());

        context.opt();

        context.setPlane(new Harrier());

        context.opt();
    }
}
