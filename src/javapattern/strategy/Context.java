package javapattern.strategy;

/**
 * @author hbw
 */
public class Context {

    private Plane plane;

    public void setPlane(
            Plane plane) {

        this.plane = plane;
    }

    public void opt() {

        this.plane.categoryFeature();
    }
}
