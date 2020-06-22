package observer;

import java.util.Observable;
import java.util.Vector;

/**
 * @author : hbw
 * @desctiption : 在我看来就是一个事件通知机制，一个对象的状态发生变化，会通过观察者告诉给其他对象
 * 因为java中已经有了观察者的实现，所以这里仍然沿用，并且在changed实例变量上增加了volatile修饰符，
 * 以便在多线程情况下维持其可见性
 * 使用场景：比如在热部署情况下，配置参数发生变化，通过观察者通知其他对象同步
 * @date : 2020-06-22 09:03
 */
public class ObserverDemo {
}

// 观察者
interface SimpleObserver{
    void update(SimpleObservable simpleObservable, Object arg);
}
// 被观察者
abstract class SimpleObservable{
    // 状态标志
    private volatile boolean changed = false; // 增加volatile修饰符，保证多线程可见性
    protected synchronized void setChanged(){
        changed = true;
    }
    public synchronized boolean hasChanged(){
        return changed;
    }
    protected synchronized void clearChanged(){
        changed = false;
    }

    // 观察者列表
    private Vector<SimpleObserver> observerVector;
    public SimpleObservable(){
        observerVector = new Vector<>();
    }
    public synchronized void addObserver(SimpleObserver simpleObserver){
        if(null == simpleObserver){
            throw new NullPointerException();
        }else if(!observerVector.contains(simpleObserver)){
            observerVector.addElement(simpleObserver);
        }
    }
    public synchronized void deleteObserver(SimpleObserver simpleObserver){
        observerVector.removeElement(simpleObserver);
    }
    public synchronized void deleteObservers(){
        observerVector.removeAllElements();
    }
    // 注意，状态的改变需要加sync，但是遍历observer.update不需要
    public void notifyObservers(Object arg){
        synchronized (this){
            if(!changed) return;
            clearChanged();
        }
        observerVector.forEach(observer -> observer.update(this, arg));
    }
    public void notifyObservers(){
        notifyObservers(null);
    }
    public synchronized int countObservers(){
        return observerVector.size();
    }
}

class MySimpleObservable extends SimpleObservable{
    private int state;
    public void setState(int state){
        this.state = state;
        this.setChanged(); // 状态发生变化，状态标志位改为true
        this.notifyObservers(state); // 通知观察者
    }
    public int getState() {
        return state;
    }
}

class MySimpleObserver1 implements SimpleObserver{
    private Client1 client;
    public MySimpleObserver1(Client1 client){
        this.client = client;
    }

    @Override
    public void update(SimpleObservable simpleObservable, Object arg) {
        client.plus((int)arg);
    }
}

class MySimpleObserver2 implements SimpleObserver{
    private Client2 client;
    public MySimpleObserver2(Client2 client){
        this.client = client;
    }

    @Override
    public void update(SimpleObservable simpleObservable, Object arg) {
        client.multiply((int)arg);
    }
}

class Client1{
    public void plus(int arg){
        System.out.println("client1::plus "+ (20+arg));
    }
}

class Client2{
    public void multiply(int arg){
        System.out.println("client2::multiply "+ (3*arg));
    }
}

class testObserver{
    public static void main(String[] args) {
        // 创建client的观察者
        MySimpleObserver1 mySimpleObserver1 = new MySimpleObserver1(new Client1());
        MySimpleObserver2 mySimpleObserver2 = new MySimpleObserver2(new Client2());
        // 创建被观察者，并为其添加观察者
        MySimpleObservable mySimpleObservable = new MySimpleObservable();
        mySimpleObservable.addObserver(mySimpleObserver1);
        mySimpleObservable.addObserver(mySimpleObserver2);
        // 被观察者状态改变，观察者通知客户端
        System.out.println("observers count: "+ mySimpleObservable.countObservers());
        System.out.println("state changed to "+ 1+ ":");
        mySimpleObservable.setState(1);
        System.out.println("state changed to "+ 2+ ":");
        mySimpleObservable.setState(2);
    }
}
