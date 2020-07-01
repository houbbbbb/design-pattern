package designpattern.singleton;

/**
 * @author : hbw
 * @desctiption : 保证一个类仅有一个实例，并提供一个访问它的全局访问点。节省内存。
 * 这里只展示线程安全的
 * @date : 2020-06-19 08:53
 */
public class SingletonDemo {
}
// 第一种，并且是最好的实现方式，枚举，饿汉式
enum Single1{
    SINGLETON;
    public void sayHello(){
        System.out.println("enum say hello");
    }
}

// 第二种，常规饿汉式
class Single2{
    private Single2(){}
    private static final Single2 SINGLE = new Single2();
    public static Single2 getInstance(){
        return SINGLE;
    }
    public void sayHello(){
        System.out.println("饿汉式 say hello");
    }
}

// 第三种，静态内部类，懒汉式，懒汉式首选
class Single3{
    private Single3(){}
    private static class SingleHolder{
        private static final Single3 SNGLE = new Single3();
    }
    public static Single3 getInstance(){
        return SingleHolder.SNGLE;
    }
    public void sayHello(){
        System.out.println("inner static say hello");
    }
}

// 双重校验锁, 懒汉式
class Single4{
    private Single4(){}
    private static Single4 single4;
    public static Single4 getInstance(){
        if(null == single4){
            synchronized (Single4.class){
                if(null == single4){
                    return new Single4();
                }
            }
        }
        return single4;
    }
    public void sayHello(){
        System.out.println("double judge say hello");
    }
}

// 直接加锁，懒汉式，效率最低
class Single5{
    private Single5(){}
    private static Single5 single5;
    public static synchronized Single5 getInstance(){
        if(null == single5){
            return new Single5();
        }
        return single5;
    }
    public void sayHello(){
        System.out.println("normal sync lazy say hello");
    }
}

class TestSingleton{
    public static void main(String[] args) {
        Single1.SINGLETON.sayHello();
        Single2.getInstance().sayHello();
        Single3.getInstance().sayHello();
        Single4.getInstance().sayHello();
        Single5.getInstance().sayHello();
    }
}