package javapattern.mediator;

/**
 * @author hbw
 */
public interface Mediator {

    /**
     * 操作
     * @param paneType
     */
    void option(
            Pane.PaneType paneType);

    /**
     * 添加pane
     * @param pane
     */
    void addPane(
            Pane pane);
}
