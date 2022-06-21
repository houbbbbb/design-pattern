package javapattern.command;

/**
 * @author hbw
 */
public class BoardScreenImpl
        implements BoardScreen {

    @Override
    public void open() {

        System.out.println("打开");
    }

    @Override
    public void create() {

        System.out.println("创建");
    }

    @Override
    public void edit() {

        System.out.println("编辑");
    }
}
