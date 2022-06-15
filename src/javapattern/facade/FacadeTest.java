package javapattern.facade;

import org.junit.Test;

/**
 * @author hbw
 */
public class FacadeTest {

    @Test
    public void test() {

        Facade facade = new FacadeImpl(
                new Service1Impl(),
                new Service2Impl(),
                new Service3Impl());

        facade.opt2();
        System.out.println();
        facade.opt();
        System.out.println();
        facade.opt1();
        System.out.println();
        facade.opt3();
    }
}
