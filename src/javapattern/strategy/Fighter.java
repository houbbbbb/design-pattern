package javapattern.strategy;

/**
 * @author hbw
 */
public class Fighter
        implements Plane {

    @Override
    public void categoryFeature() {

        System.out.println(PlaneType.FIGHTER.getName()
                + " "
                + TakeOffType.LONG_DISTANCE_TAKEOFF.getName()
                + " "
                + FlyType.SUPERSONIC_FLY.getName());
    }
}
