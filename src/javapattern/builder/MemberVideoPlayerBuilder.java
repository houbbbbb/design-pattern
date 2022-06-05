package javapattern.builder;

/**
 * @author 86136
 */
public class MemberVideoPlayerBuilder
        implements VideoPlayerBuilder {

    private static final String MEMBER = "记忆模式";

    private final VideoPlayer videoPlayer = new VideoPlayer();

    @Override
    public void buildMenu() {

        videoPlayer.setMenu(MEMBER + MENU);
    }

    @Override
    public void buildList() {

        videoPlayer.setList(MEMBER + LIST);
    }

    @Override
    public void buildWin() {

        videoPlayer.setWin(MEMBER + WIN);
    }

    @Override
    public void buildBar() {

        videoPlayer.setBar(MEMBER + BAR);
    }

    @Override
    public VideoPlayer build() {

        return videoPlayer;
    }
}
