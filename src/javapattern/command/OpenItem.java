package javapattern.command;

/**
 * @author hbw
 */
public class OpenItem
        implements MenuItem {

    private Command command;

    public OpenItem(
            Command command) {

        this.setCommand(command);
    }

    private void setCommand(
            Command command) {

        if (command == null) {

            throw new IllegalArgumentException("命令不能为空");
        }

        this.command = command;
    }

    @Override
    public void click() {

        this.command.execute();
    }
}
