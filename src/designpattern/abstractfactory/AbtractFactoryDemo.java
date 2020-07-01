package designpattern.abstractfactory;

/**
 * @author : hbw
 * @desctiption : 提供一个创建一系列相关或有依赖关系的对象的接口，而不用指定具体的类。
 * @date : 2020-07-01 14:17
 */
public class AbtractFactoryDemo {
}

interface Factory {
    Type1 getType1(String type1);
    Type2 getType2(String type2);
}

abstract class AbstractFactory implements Factory {
    @Override
    public Type1 getType1(String type1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Type2 getType2(String type2) {
        throw new UnsupportedOperationException();
    }
}

class Type1Factory extends AbstractFactory {
    @Override
    public Type1 getType1(String type1) {
        Type1 type11 = null;
        switch (type1) {
            case "impl1": type11 = new Type1Impl1(); break;
            case "impl2": type11 = new Type1Impl2(); break;
            case "impl3": type11 = new Type1Impl3(); break;
        }
        return type11;
    }
}

class Type2Factory extends AbstractFactory {
    @Override
    public Type2 getType2(String type2) {
        Type2 type21 = null;
        switch (type2) {
            case "impl1": type21 = new Type2Impl1(); break;
            case "impl2": type21 = new Type2Impl2(); break;
            case "impl3": type21 = new Type2Impl3(); break;
        }
        return type21;
    }
}


interface Type1 { }

class Type1Impl1 implements Type1 {}
class Type1Impl2 implements Type1 {}
class Type1Impl3 implements Type1 {}

interface Type2 { }

class Type2Impl1 implements Type2 {}
class Type2Impl2 implements Type2 {}
class Type2Impl3 implements Type2 {}

class FactoryImpl implements Factory {
    private Type1Factory type1Factory;
    private Type2Factory type2Factory;
    public FactoryImpl () {
        type1Factory = new Type1Factory();
        type2Factory = new Type2Factory();
    }

    @Override
    public Type1 getType1(String type1) {
        return type1Factory.getType1(type1);
    }

    @Override
    public Type2 getType2(String type2) {
        return type2Factory.getType2(type2);
    }
}

class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new FactoryImpl();
        System.out.println(factory.getType1("impl1"));
        System.out.println(factory.getType1("impl2"));
        System.out.println(factory.getType1("impl3"));
        System.out.println();
        System.out.println(factory.getType2("impl1"));
        System.out.println(factory.getType2("impl2"));
        System.out.println(factory.getType2("impl3"));
    }
}