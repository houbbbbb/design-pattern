package designpattern.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : hbw
 * @desctiption : 在不破坏封装性的前提下，捕获一个对象的内部状态，并在对象之外保存这个状态。
 * 备忘录既然有记录和恢复的功能，那么是不是应该指定哪个状态记录了什么？
 * 恢复时指定恢复哪个状态？
 * Java事务的回滚是不是用到了备忘录模式？
 * 原型模式与备忘录模式相结合是不是就可以有效的使用对象不同阶段的快照了呢？
 *
 * 所以本人认为备忘录模式应该是以key-value的形式存储的，key为状态，value为这个状态下的对象快照
 * 这样取值的时候直接用状态来取对应状态下这个对象的快照就可以获取到当时这个对象的所有信息，这样就可以做很多事情了
 *
 * 根据状态来记录值与取值，而不是单纯的记录状态
 * 普通的实例有些本末倒置，所以自己实现了一个
 *
 * 一般实例中是用来记录和恢复对象本身以前的状态，恢复以后对象现在的状态就改变了
 * 而本实例中，获取对象以前状态，又不改变现有状态，如果想要改变现有状态，直接赋值就行了
 * @date : 2020-07-03 10:50
 */
public class MementoDemo {
}

/**
 * 改造后的备忘录模式，与原型模式结合，更具有实用性
 * 注意：通过这种方式恢复以后，返回的不再是原来对象，而是拷贝的快照对象
 */
class Memento<T> {
    private String state;
    private T t;

    public Memento (String state, T t) {
        this.state = state;
        this.t = t;
    }

    public String getState() {
        return state;
    }

    public T getShortcut() {
        return t;
    }
}

class Originator implements Cloneable {
    private String state;
    private String name;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Memento<Originator> saveToMemento () {
        try {
            Originator originator = (Originator) this.clone();
            return new Memento<>(state, originator);
        } catch (Exception e) {}
        return null;
    }

    public Originator recovery (Memento<Originator> memento) {
        return null != memento ? memento.getShortcut() : null;
    }
}

/**
 * 它的作用是记录和获取原状态
 */
class CareTaker<T> {
    private Map<String, Memento<T>> map = new HashMap<>();

    public void put (Memento<T> memento) {
        map.put(memento.getState(), memento);
    }

    public Memento<T> get(String state) {
        return map.get(state);
    }
}

class MementoTest {
    public static void main(String[] args) {
        CareTaker<Originator> careTaker = new CareTaker<>();

        Originator originator = new Originator();
        originator.setState("abc");
        originator.setName("hello world");
        careTaker.put(originator.saveToMemento());

        originator.setState("bcd");
        originator.setName("kkk");
        careTaker.put(originator.saveToMemento());

        System.out.println(originator.recovery(careTaker.get("abc")).getName());
        System.out.println(originator.recovery(careTaker.get("bcd")).getName());
    }
}