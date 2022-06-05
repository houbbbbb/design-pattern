package javapattern.builder;

/**
 * @author 86136
 */
public interface VideoPlayerBuilder {

    String MENU = "菜单";

    String LIST = "列表";

    String WIN = "主窗口";

    String BAR = "控制条";

    /**
     * 创建菜单
     */
    void buildMenu();

    /**
     * 创建列表
     */
    void buildList();

    /**
     * 创建主窗口
     */
    void buildWin();

    /**
     * 创建控制条
     */
    void buildBar();

    /**
     * 创建视频播放器
      * @return
     */
    VideoPlayer build();
}
