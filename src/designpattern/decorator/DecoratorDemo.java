package designpattern.decorator;

/**
 * @todo: 动态的给对象添加一些额外的职责
 * 与静态代理很相似
 * @author: hbw
 * @date: 2020/7/13
 **/
public class DecoratorDemo {
    interface Shape {
        /**
         * 画
         */
        void draw ();
    }

    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("draw circle");
        }
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("draw rectangle");
        }
    }

    static class Decorator implements Shape {
        protected Shape shape;
        public Decorator (Shape shape) {
            this.shape = shape;
        }

        @Override
        public void draw() {
            shape.draw();
        }
    }

    static class RedDecorator extends Decorator {
        public RedDecorator (Shape shape) {
            super(shape);
        }

        @Override
        public void draw() {
            content();
            shape.draw();
            border();
        }

        public void border () {
            System.out.println("red border");
        }

        public void content () {
            System.out.println("content");
        }
    }

    public static void main(String[] args) {
        Decorator redCircle = new RedDecorator(new Circle());

        Decorator redRectangle = new RedDecorator(new Rectangle());

        redCircle.draw();
        System.out.println();
        redRectangle.draw();
    }
}
