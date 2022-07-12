package javapattern.template;

import org.junit.Test;

/**
 * @author hbw
 */
public class TemplateTest {

    @Test
    public void test() {

        AbstractSuper abstractSuper = new Sub();

        abstractSuper.opt();
    }
}
