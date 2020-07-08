package designpattern.strategy;

import java.net.ContentHandler;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @todo: 定义一系列算法，把它们一个个封装起来，并且可以相互替换
 * @author: hbw
 * @date: 2020/7/8
 **/
public class StrategyDemo {
    interface Strategy {
        /**
         * 操作
         * @param a
         * @param b
         */
        Integer option (Integer a, Integer b);
    }

    static class PlusStrategy implements Strategy {
        @Override
        public Integer option(Integer a, Integer b) {
            return a + b;
        }
    }

    static class MultiplyStrategy implements Strategy {
        @Override
        public Integer option(Integer a, Integer b) {
            return a * b;
        }
    }

    static class Context {
        private Strategy strategy;
        public Context (Strategy strategy) {
            this.strategy = strategy;
        }

        public Integer option (Integer a, Integer b) {
            return strategy.option(a, b);
        }
    }

    public static void main(String[] args) {
        Context ctx = new Context(new PlusStrategy());
        int re = ctx.option(3, 2);
        System.out.println("plus strategy : " + re);
        ctx = new Context(new MultiplyStrategy());
        re = ctx.option(3, 2);
        System.out.println("multiply strategy : " + re);
    }
}
