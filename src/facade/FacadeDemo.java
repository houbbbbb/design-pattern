package facade;

/**
 * @author : hbw
 * @desctiption : 对外提供统一接口，屏蔽内部负复杂的实现流程，例如：springMVC的 DAO Service Controller
 * @date : 2020-06-16 11:06
 */
public class FacadeDemo {
}
// 功能接口
interface FacadeCap{
    void play();
}

class FacadeCapImpl1 implements FacadeCap{
    @Override
    public void play() {
        System.out.println("Facade1::play()");
    }
}

class FacadeCapImpl2 implements FacadeCap{
    @Override
    public void play() {
        System.out.println("Facade2::play()");
    }
}

class FacadeCapImpl3 implements FacadeCap{
    @Override
    public void play() {
        System.out.println("Facade3::play()");
    }
}

// 统一外部调用接口
interface Facade{
    void play1();
    void play2();
    void play3();
}

class FacadeImpl implements Facade{
    private FacadeCap facadeCap1;
    private FacadeCap facadeCap2;
    private FacadeCap facadeCap3;

    public FacadeImpl(){
        facadeCap1 = new FacadeCapImpl1();
        facadeCap2 = new FacadeCapImpl2();
        facadeCap3 = new FacadeCapImpl3();
    }

    @Override
    public void play1() {
        facadeCap1.play();
    }

    @Override
    public void play2() {
        facadeCap2.play();
    }

    @Override
    public void play3() {
        facadeCap3.play();
    }
}
// 测试
class FacadeTest{
    public static void main(String[] args){
        Facade facade = new FacadeImpl();
        facade.play1();
        facade.play2();
        facade.play3();
    }
}

