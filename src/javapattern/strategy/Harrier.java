package javapattern.strategy;

/**
 * @author hbw
 */
public class Harrier
        implements Plane {

    @Override
    public void categoryFeature() {

        System.out.println(PlaneType.HARRIER.getName()
                + " "
                + TakeOffType.VERTICAL_TAKEOFF.getName()
                + " "
                + FlyType.SUPERSONIC_FLY.getName());
    }
}
