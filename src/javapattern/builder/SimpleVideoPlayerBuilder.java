package javapattern.builder;

/**
 * @author 86136
 */
public class SimpleVideoPlayerBuilder
        implements VideoPlayerBuilder {

    private static final String SIMPLE = "精简模式";

    private final VideoPlayer videoPlayer = new VideoPlayer();

    @Override
    public void buildMenu() {

        videoPlayer.setMenu(SIMPLE + MENU);
    }

    @Override
    public void buildList() {

        videoPlayer.setList(SIMPLE + LIST);
    }

    @Override
    public void buildWin() {

        videoPlayer.setWin(SIMPLE + WIN);
    }

    @Override
    public void buildBar() {

        videoPlayer.setBar(SIMPLE + BAR);
    }

    @Override
    public VideoPlayer build() {

        return videoPlayer;
    }
}
