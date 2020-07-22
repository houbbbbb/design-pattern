package designpattern.nullobj;

/**
 * @todo: 使用空对象代替null
 * @author: hbw
 * @date: 2020/7/22
 **/
public class NullDemo {
    interface Value {
        /**
         * 是否为空
         * @return
         */
        Boolean nonNull ();

        /**
         * 获取名字
         * @return
         */
        String getName();
    }

    static abstract class AbstractValue implements Value {
        protected String name;
    }

    static class RealValue extends AbstractValue {
        private String name;
        public RealValue (String name) {
            this.name = name;
        }

        @Override
        public Boolean nonNull() {
            return true;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    static class NullValue extends AbstractValue {
        @Override
        public String getName() {
            return "non name";
        }

        @Override
        public Boolean nonNull() {
            return false;
        }
    }

    static class ValueFactory {
        private String existsName = "123";
        public Value getValue (String name) {
            if (existsName.equals(name)) {
                return new RealValue(name);
            }
            return new NullValue();
        }
    }

    public static void main(String[] args) {
        ValueFactory factory = new ValueFactory();

        System.out.println(factory.getValue("123").getName());
        System.out.println(factory.getValue("sss").getName());
    }
}
