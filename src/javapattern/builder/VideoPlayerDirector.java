package javapattern.builder;

import javapattern.util.BeanUtils;
import javapattern.util.ConfigUtils;
import javapattern.util.XMLUtils;

/**
 * @author 86136
 */
public class VideoPlayerDirector {

    private VideoPlayerBuilder videoPlayerBuilder;

    private BuilderVO builderVO;

    public VideoPlayer construct(
            String builderConfig) {

        return setConfig(builderConfig)
                .menu()
                .list()
                .win()
                .bar()
                .build();
    }

    private VideoPlayer build() {

        return videoPlayerBuilder.build();
    }

    private VideoPlayerDirector setConfig(
            String builderConfig) {

        String builder = ConfigUtils.getProp(builderConfig);

        builderVO = XMLUtils.builderProp(builder);

        videoPlayerBuilder = BeanUtils
                .getBean(builderVO.getClassname());

        return this;
    }

    private VideoPlayerDirector menu() {

        if (isBuildMenu()) {
            videoPlayerBuilder.buildMenu();
        }

        return this;
    }

    private VideoPlayerDirector list() {

        if (isBuildList()) {
            videoPlayerBuilder.buildList();
        }

        return this;
    }

    private VideoPlayerDirector win() {

        if (isBuildWin()) {
            videoPlayerBuilder.buildWin();
        }

        return this;
    }

    private VideoPlayerDirector bar() {

        if (isBuildBar()) {
            videoPlayerBuilder.buildBar();
        }

        return this;
    }

    private boolean isBuildMenu() {

        return builderVO.getMenu();
    }

    private boolean isBuildList() {

        return builderVO.getList();
    }

    private boolean isBuildWin() {

        return builderVO.getWin();
    }

    private boolean isBuildBar() {

        return builderVO.getBar();
    }
}
