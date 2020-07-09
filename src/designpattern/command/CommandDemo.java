package designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @todo: 核心思想是将请求以命令的形式进行统一化封装
 * @author: hbw
 * @date: 2020/7/9
 **/
public class CommandDemo {
    interface Order {
        /**
         * 执行命令
         */
        void execute();
    }

    static class Request {

        public void buy () {
            System.out.println("buy something");
        }

        public void sell () {
            System.out.println("sell something");
        }
    }

    static class Buy implements Order {
        private Request request;

        public Buy (Request request) {
            this.request = request;
        }

        @Override
        public void execute() {
            request.buy();
        }
    }

    static class Sell implements Order {
        private Request request;

        public Sell (Request request) {
            this.request = request;
        }

        @Override
        public void execute() {
            request.sell();
        }
    }

    static class Broker {
        List<Order> orders;

        public Broker () {
            orders = new ArrayList<>(16);
        }

        public void addOrder (Order order) {
            orders.add(order);
        }

        /**
         * 职责链模式
         */
        public void placeOrders () {
            orders.forEach(Order::execute);
            orders.clear();
        }
    }

    public static void main(String[] args) {
        Request request = new Request();

        Order buy = new Buy(request);
        Order sell = new Sell(request);

        Broker broker = new Broker();
        broker.addOrder(buy);
        broker.addOrder(sell);
        broker.placeOrders();
    }
}
