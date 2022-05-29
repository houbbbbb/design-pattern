package javapattern.simplefactory;

public class Triangle
        implements Shape {

    @Override
    public void drawl() {

        System.out.println("drawl triangle");
    }

    @Override
    public void erase() {

        System.out.println("erase triangle");
    }
}
