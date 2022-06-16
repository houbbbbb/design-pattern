package javapattern.flyweight;

import org.junit.Test;

/**
 * @author hbw
 */
public class FlyweightTest {

    @Test
    public void testEquals() {

        Material animation1 = FlyweightFactory
                .getMaterial(FlyweightFactory.Type.ANIMATION);

        Material animation2 = FlyweightFactory
                .getMaterial(FlyweightFactory.Type.ANIMATION);

        System.out.println(animation1 == animation2);
    }

    @Test
    public void testInnerState() {

        String imageCategory = FlyweightFactory
                .getMaterial(FlyweightFactory.Type.IMAGE)
                .category();

        System.out.println(imageCategory);

        String animationCategory = FlyweightFactory
                .getMaterial(FlyweightFactory.Type.ANIMATION)
                .category();

        System.out.println(animationCategory);

        String videoCategory = FlyweightFactory
                .getMaterial(FlyweightFactory.Type.VIDEO)
                .category();

        System.out.println(videoCategory);
    }

    @Test
    public void testOuterState() {

        FlyweightFactory
                .getMaterial(FlyweightFactory.Type.IMAGE)
                .opt(new Coordinate(1, 3), 4);

        FlyweightFactory
                .getMaterial(FlyweightFactory.Type.ANIMATION)
                .opt(new Coordinate(5, 3), 7);

        FlyweightFactory
                .getMaterial(FlyweightFactory.Type.VIDEO)
                .opt(new Coordinate(7, 2), 9);
    }
}
