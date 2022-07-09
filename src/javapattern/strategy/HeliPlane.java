package javapattern.strategy;

/**
 * 直升机
 * @author hbw
 */
public class HeliPlane
        implements Plane {

    @Override
    public void categoryFeature() {

        System.out.println(PlaneType.HELICOPTER.getName()
                + " "
                + TakeOffType.VERTICAL_TAKEOFF.getName()
                + " "
                + FlyType.SUBSONIC_FLY.getName());
    }
}
