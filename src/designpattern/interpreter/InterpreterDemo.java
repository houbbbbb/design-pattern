package designpattern.interpreter;

/**
 * @todo: 给定一个语言，定义它的文法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子。
 * 根据语法规则解释语言
 * @author: hbw
 * @date: 2020/7/10
 **/
public class InterpreterDemo {
    interface Expression {
        /**
         * 解释器
         * @param context
         * @return
         */
        Boolean interpret (String context);
    }

    static class Terminal implements Expression {
        private String data;
        public Terminal (String data) {
            this.data = data;
        }

        @Override
        public Boolean interpret(String context) {
            if (null != context && context.contains(data)) {
                return true;
            }
            return false;
        }
    }

    static class And implements Expression {
        private Expression expression1;
        private Expression expression2;

        public And (Expression expression1, Expression expression2) {
            this.expression1 = expression1;
            this.expression2 = expression2;
        }

        @Override
        public Boolean interpret(String context) {
            return expression1.interpret(context) && expression2.interpret(context);
        }
    }

    static class Or implements Expression {
        private Expression expression1;
        private Expression expression2;

        private Or (Expression expression1, Expression expression2) {
            this.expression1 = expression1;
            this.expression2 = expression2;
        }

        @Override
        public Boolean interpret(String context) {
            return expression1.interpret(context) || expression2.interpret(context);
        }
    }

    interface Rule {
        /**
         * 获取男性
         * @return
         */
        Expression getMale ();

        /**
         * 获取已婚
         * @return
         */
        Expression getMarried ();
    }

    static class RuleImpl implements Rule {

        @Override
        public Expression getMale() {
            Expression expression1 = new Terminal("Robot");
            Expression expression2 = new Terminal("John");
            return new Or(expression1, expression2);
        }

        @Override
        public Expression getMarried() {
            Expression expression1 = new Terminal("Julie");
            Expression expression2 = new Terminal("Married");
            return new And(expression1, expression2);
        }
    }

    public static void main(String[] args) {
        Rule rule = new RuleImpl();

        Expression male = rule.getMale();
        Expression married = rule.getMarried();

        boolean b1 = male.interpret("Is John a Robot?");
        boolean b2 = married.interpret("Julie or Married?");

        System.out.println("b1 --- " + b1 + ", b2 --- " + b2);
    }
}
