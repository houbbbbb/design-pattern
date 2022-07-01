package javapattern.memento;

import org.junit.Test;

/**
 * @author hbw
 */
public class MementoTest {

    @Test
    public void test() {

        Originator originator = new Originator();

        originator.setState(1);

        originator.setState(2);

        originator.setState(3);

        originator.setState(4);

        originator.setState(5);

        originator.printState();

        originator.undo();

        originator.printState();

        originator.undo();

        originator.printState();

        originator.undo();

        originator.printState();

        originator.undo();

        originator.printState();

        originator.undo();

        originator.printState();

        originator.undo();

        originator.printState();

        originator.redo();

        originator.printState();

        originator.redo();

        originator.printState();

        originator.redo();

        originator.printState();

        originator.setState(9);

        originator.undo();

        originator.printState();

        originator.redo();

        originator.printState();

        originator.redo();

        originator.printState();
    }
}
