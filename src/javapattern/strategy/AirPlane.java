package javapattern.strategy;

/**
 * @author hbw
 */
public class AirPlane
        implements Plane {

    @Override
    public void categoryFeature() {

        System.out.println(PlaneType.AIRPLANE.getName()
                + " "
                + TakeOffType.LONG_DISTANCE_TAKEOFF.getName()
                + " "
                + FlyType.SUBSONIC_FLY.getName());
    }
}
