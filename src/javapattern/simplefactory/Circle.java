package javapattern.simplefactory;

/**
 * @author 86136
 */
public class Circle
        implements Shape {

    @Override
    public void drawl() {

        System.out.println("drawl circle");
    }

    @Override
    public void erase() {

        System.out.println("erase circle");
    }
}
