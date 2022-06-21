package javapattern.command;

import org.junit.Test;

/**
 * @author hbw
 */
public class CommandTest {

    @Test
    public void test() {

        MenuItem openItem = new OpenItem(
                new OpenCommand(new BoardScreenImpl()));

        MenuItem createItem = new CreateItem(
                new CreateCommand(new BoardScreenImpl()));

        MenuItem editItem = new EditItem(
                new EditCommand(new BoardScreenImpl()));

        openItem.click();

        createItem.click();

        editItem.click();
    }
}
