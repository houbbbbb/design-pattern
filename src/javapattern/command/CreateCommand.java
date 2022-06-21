package javapattern.command;

/**
 * @author hbw
 */
public class CreateCommand
        implements Command {

    private BoardScreen boardScreen;

    public CreateCommand(
            BoardScreen boardScreen) {

        this.setBoardScreen(boardScreen);
    }

    private void setBoardScreen(
            BoardScreen boardScreen) {

        if (boardScreen == null) {

            throw new IllegalArgumentException("操作对象不能为空");
        }

        this.boardScreen = boardScreen;
    }

    @Override
    public void execute() {

        this.boardScreen.create();
    }
}
