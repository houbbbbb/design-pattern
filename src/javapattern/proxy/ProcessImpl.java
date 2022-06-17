package javapattern.proxy;

/**
 * @author hbw
 */
public class ProcessImpl
        implements Process {

    @Override
    public void method() {

        System.out.println("执行 method()");
    }
}
