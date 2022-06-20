package javapattern.chainofresposibility;

import org.junit.Test;

/**
 * @author hbw
 */
public class ChainOfResponsibilityTest {

    @Test
    public void test() {

        Approver approver = new Director(
                "hello",
                new Manager(
                        "good",
                        new GeneralManager("me")));

        approver.process(new ParamValue(2));

        approver.process(new ParamValue(7));

        approver.process(new ParamValue(18));

        approver.process(new ParamValue(33));
    }
}
