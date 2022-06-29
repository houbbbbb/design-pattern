package javapattern.mediator;

import org.junit.Test;

/**
 * @author hbw
 */
public class MediatorTest {

    @Test
    public void test() {

        Mediator mediator = new ConcreteMediator();

        Pane textPane = new TextPane(mediator);
        Pane listPane = new ListPane(mediator);
        Pane graphicPane = new GraphicPane(mediator);

        mediator.addPane(textPane);
        mediator.addPane(listPane);
        mediator.addPane(graphicPane);

        listPane.trigger();
        textPane.trigger();
        graphicPane.trigger();
    }
}
