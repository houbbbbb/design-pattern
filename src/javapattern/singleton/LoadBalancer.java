package javapattern.singleton;

/**
 * @author 86136
 */
public class LoadBalancer {

    private LoadBalancer() {}

    public static LoadBalancer getInstance() {

        return Holder.LOAD_BALANCER;
    }

    private static class Holder {

        private static final LoadBalancer LOAD_BALANCER = new LoadBalancer();
    }
}
