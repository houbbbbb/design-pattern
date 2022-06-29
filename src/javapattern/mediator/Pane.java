package javapattern.mediator;

/**
 * @author hbw
 */
public interface Pane {

    /**
     * 触发
     */
    void trigger();

    enum PaneType {

        /**
         * 文本
         */
        TEXT_PANE,

        /**
         * 列表
         */
        LIST_PANE,

        /**
         * 图形
         */
        GRAPHIC_PANE
    }
}
