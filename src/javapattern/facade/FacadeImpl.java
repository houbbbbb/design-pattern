package javapattern.facade;

/**
 * @author hbw
 */
public class FacadeImpl
        implements Facade {

    private final Service1 service1;
    private final Service2 service2;
    private final Service3 service3;

    public FacadeImpl(
            Service1 service1,
            Service2 service2,
            Service3 service3) {

        this.service1 = service1;
        this.service2 = service2;
        this.service3 = service3;
    }

    @Override
    public void opt() {

        service1.opt1();
        service2.opt2();
        service3.opt3();
    }

    @Override
    public void opt1() {

        service1.opt1();
    }

    @Override
    public void opt2() {

        service2.opt2();
    }

    @Override
    public void opt3() {

        service3.opt3();
    }
}
