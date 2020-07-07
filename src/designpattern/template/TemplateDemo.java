package designpattern.template;

/**
 * @Td: 在方法中定义一套处理事务的通用逻辑，某些步骤交由子类实现。
 * @At: hbw
 * @Tm: 2020/7/6
 **/
public class TemplateDemo {
    interface Tmp {
        void play();
    }

    static abstract class AbsTmp implements Tmp {
        public void play() {
            init();
            start();
            end();
        }
        abstract void init();
        abstract void start();
        abstract void end();
    }

    static class Tmp1 extends AbsTmp {
        @Override
        void init() {
            System.out.println("Tmp1::init");
        }

        @Override
        void start() {
            System.out.println("Tmp1::start");
        }

        @Override
        void end() {
            System.out.println("Tmp1::end");
        }
    }

    static class Tmp2 extends AbsTmp {

        @Override
        void init() {
            System.out.println("Tmp2::init");
        }

        @Override
        void start() {
            System.out.println("Tmp2::start");
        }

        @Override
        void end() {
            System.out.println("Tmp2::end");
        }
    }

    public static void main(String[] args) {
        Tmp tmp1 = new Tmp1();
        tmp1.play();

        Tmp tmp2 = new Tmp2();
        tmp2.play();
    }

}
