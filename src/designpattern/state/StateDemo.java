package designpattern.state;

import java.util.LinkedList;

/**
 * @todo: 允许对象内部状态改变时，改变其行为
 * 我感觉可以和职责链模式一起使用，处理器中通过状态来改变行为，超帅
 * 职责链模式与合成模式一起用比较合理
 * @author: hbw
 * @date: 2020/7/7
 **/
public class StateDemo {
    interface State {
        /**
         * 执行
         * @param ctx 记录状态
         */
        void exc(Context ctx);

        /**
         * 打印name
         * @param name 名称
         */
        void name (String name);
    }

    static class State1 implements State {
        @Override
        public void exc(Context ctx) {
            ctx.setSt(this);
        }

        @Override
        public void name (String name) {
            System.out.println("state1 --- " + name);
        }
    }

    static class State2 implements State {
        @Override
        public void exc(Context ctx) {
            ctx.setSt(this);
        }

        @Override
        public void name (String name) {
            System.out.println("state2 --- " + name);
        }

    }

    static class Context {
        private State st;

        public State getSt() {
            return st;
        }

        public void setSt(State st) {
            this.st = st;
        }
    }

    public static void main(String[] args) {
        LinkedList<State> stL = new LinkedList<>();
        stL.offer(new State1());
        stL.offer(new State2());

        // 对象的装载与调用应该是分开的，要不然起不到相应的作用，当然这种规则应该属于职责链范畴
        String name = "myName";
        Context ctx = new Context();
        stL.forEach(st -> {
            // 对象状态改变与行为调用的方法都应该是接口定义的规范，如果是合成模式，就可以做到分层调用的一致性
            // 再加上状态模式就是特别好的组合了
            st.exc(ctx);
            ctx.getSt().name(name);
        });
    }
}
