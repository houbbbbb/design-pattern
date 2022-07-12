package javapattern.template;

/**
 * @author hbw
 */
public abstract class AbstractSuper {

    public void opt() {

        opt1();
        opt2();
        opt3();
    }

    public void opt1() {

        System.out.println("opt1");
    }

    /**
     * 操作2
     */
    public abstract void opt2();

    public void opt3() {

        System.out.println("opt3");
    }
}
