package javapattern.builder;

/**
 * @author 86136
 */
public class FullVideoPlayerBuilder
        implements VideoPlayerBuilder {

    private static final String FULL = "完整模式";

    private final VideoPlayer videoPlayer = new VideoPlayer();

    @Override
    public void buildMenu() {

        videoPlayer.setMenu(FULL + MENU);
    }

    @Override
    public void buildList() {

        videoPlayer.setList(FULL + LIST);
    }

    @Override
    public void buildWin() {

        videoPlayer.setWin(FULL + WIN);
    }

    @Override
    public void buildBar() {

        videoPlayer.setBar(FULL + BAR);
    }

    @Override
    public VideoPlayer build() {

        return videoPlayer;
    }
}
