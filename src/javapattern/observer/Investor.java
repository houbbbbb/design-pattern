package javapattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author hbw
 */
public class Investor
        implements Observer {

    @Override
    public void update(
            Observable o,
            Object arg) {

        System.out.println("stock changed " + arg + " beyond 5%");
    }
}
