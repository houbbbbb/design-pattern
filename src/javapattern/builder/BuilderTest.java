package javapattern.builder;

import org.junit.Test;

/**
 * @author 86136
 */
public class BuilderTest {

    @Test
    public void test() {

        VideoPlayerDirector director = new VideoPlayerDirector();

        VideoPlayer videoPlayer = director
                .construct("builder.builder");

        System.out.println(videoPlayer.getMenu());
        System.out.println(videoPlayer.getList());
        System.out.println(videoPlayer.getWin());
        System.out.println(videoPlayer.getBar());
    }
}
