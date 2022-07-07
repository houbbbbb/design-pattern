package javapattern.observer;

import java.util.Observable;

/**
 * @author hbw
 */
public class Stock
        extends Observable {

    public void changeCheck(
            Integer changeNum) {

        if (changeNum > 5) {

            super.setChanged();
        }

        if (super.hasChanged()) {

            super.notifyObservers(changeNum);
        }
    }
}
