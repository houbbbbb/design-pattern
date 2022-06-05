package javapattern.singleton;

/**
 * @author 86136
 */
public class LoadBalancer {

    private LoadBalancer() {}

    private String name;

    public void setName(
            String name) {

        this.name = name;
    }

    public void print() {

        System.out.println("my name is " + name);
    }

    public static LoadBalancer getInstance() {

        return Holder.LOAD_BALANCER;
    }

    private static class Holder {

        private static final LoadBalancer LOAD_BALANCER = new LoadBalancer();
    }
}
