package javapattern.simplefactory;

/**
 * @author 86136
 */
public class Square
        implements Shape {

    @Override
    public void drawl() {

        System.out.println("drawl square");
    }

    @Override
    public void erase() {

        System.out.println("arese square");
    }
}
