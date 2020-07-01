package designpattern.factory;

/**
 * @author : hbw
 * @desctiption : 提供一个创建对象的接口，根据需求创建不同的子类对象
 * @date : 2020-06-29 16:48
 */
public class FactoryDemo {
}

interface Obj {}

class Obj1 implements Obj {}

class Obj2 implements Obj {}

class Obj3 implements Obj {}

class ObjFactory {
    public Obj getObj(String name) {
        if (null == name) return null;
        Obj obj = null;
        switch (name) {
            case "obj1" : obj = new Obj1(); break;
            case "obj2" : obj = new Obj2(); break;
            case "obj3" : obj = new Obj3(); break;
        }
        return obj;
    }
}

class FactoryTest {
    public static void main(String[] args) {
        ObjFactory objFactory = new ObjFactory();
        System.out.println(objFactory.getObj("obj1"));
        System.out.println(objFactory.getObj("obj2"));
        System.out.println(objFactory.getObj("obj3"));
    }
}