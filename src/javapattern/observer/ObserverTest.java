package javapattern.observer;

import org.junit.Test;

public class ObserverTest {

    @Test
    public void test() {

        Stock stock = new Stock();

        stock.addObserver(new Investor());

        stock.changeCheck(6);
        stock.changeCheck(7);
    }
}
