package adapter;

/**
 * @author : hbw
 * @desctiption : 非兼容接口的代码复用
 * 代码复用，使用现有的接口或类的功能为新的接口提供服务。
 * 即，将已经存在的接口或类引入到适配器中用来为新的功能提供服务。
 * （注意，前提是新接口与原有接口或类不兼容）
 * @date : 2020-06-16 11:00
 */
public class AdapterDemo {

}
// 新接口
interface NewInf{
    void play(String type, String name);
}
// 已经存在的接口
interface ExistInf{
    void play1(String name);
    void play2(String name);
}
// 已经存在的接口实现类
class ExistClass implements ExistInf{
    public void play1(String name) {
        System.out.println("play1 "+name);
    }

    public void play2(String name) {
        System.out.println("play2 "+name);
    }
}
// 适配器
class MyAdapter implements NewInf{
    ExistInf existInf;
    public MyAdapter(ExistInf existInf){
        this.existInf = existInf;
    }

    public void play(String type, String name) {
        if("1".equals(type)){
            existInf.play1(name);
        }else if("2".equals(type)){
            existInf.play2(name);
        }
    }
}
// 新接口的实现类
class UseClass implements NewInf{
    MyAdapter myAdapter; //为了尽量避免继承，所以使用成员变量的形式引入MyAdapter
    public UseClass(MyAdapter myAdapter){
        this.myAdapter = myAdapter;
    }
    public void play(String type, String name) {
        if("3".equals(type)){
            System.out.println("play3 "+name);
        }else {
            myAdapter.play(type, name);
        }
    }
}
class Test2{
    public static void main(String[] args){
        // 调用新接口
        NewInf newInf = new UseClass(new MyAdapter(new ExistClass()));
        newInf.play("1", "name1");
        newInf.play("3", "name3");
        newInf.play("2", "name2");
    }
}
