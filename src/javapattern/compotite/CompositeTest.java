package javapattern.compotite;

import org.junit.Test;

/**
 * @author hbw
 */
public class CompositeTest {

    @Test
    public void test() {

        Window window = new Window();

        Panel panel = new Panel();

        panel.add(new Text());

        window.add(new Button());
        window.add(panel);

        window.opt();
    }
}
