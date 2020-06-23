package mediator;

/**
 * @author : hbw
 * @desctiption :
 * 定义一个对象，封装一组对象的交互，从而降低对象的耦合度，避免了对象间的显示引用，并且可以独立的改变对象的行为。
 * 对象之间交互时，通过中介对象通信，解耦合。典型案例：聊天室，微服务之间通信用的MQ
 * 本例用了两种实现，一种是简单的传统实例
 * 另一种是想像的实际实际场景应用
 * 还有我认为springcloud的Integration（或stream）和MQ的结合，才是更解耦的一种中介者模式，
 * 这样既有传输媒介，而MQ的传输方式（多种MQ）又可以切换
 * 注意业务层的中间对象比如UserDTO，也是一种中介，以参数的形式出现，但是它关注的更多是传输信息的广度
 * 如果以队列为中介，关注的更多会是信息量的大小
 * 中介的好处是它是无属性的，谁都可以发送，谁都可以获取，有时候不一定非要从特定的信息源获取想要的信息，
 * 这样中介的好处就发挥出来了，不管来源，只要获取到我想要的就行。
 * @date : 2020-06-23 08:59
 */
public class MediatorDemo {
}

// 对象间通信形式
interface Mediator{
    void sendMessage(String message);
    String receiveMessage();
}

class MediatorImpl1 implements Mediator{
    private String message;
    @Override
    public void sendMessage(String message) {
        this.message = message;
    }

    @Override
    public String receiveMessage() {
        return message;
    }
}

// 聊天室形式
class SimpleMediator{
    public static void showMessage(Me me, String message){
        System.out.println(me.getName() + " send " + message);
    }
}

class Me{
    private String name;
    private String message;

    // 发送消息通过Mediator解耦合
    public void sendMessage(){
        SimpleMediator.showMessage(this, message);
    }

    public void sendMessage1(Mediator mediator){
        mediator.sendMessage(message);
        System.out.println("send : " + message);
    }

    public void receiveMessage1(Mediator mediator){
        String re = mediator.receiveMessage();
        System.out.println("re : " + re);
    }

    public static Me create(){
        return new Me();
    }

    public String getName() {
        return name;
    }

    public Me setName(String name) {
        this.name = name;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Me setMessage(String message) {
        this.message = message;
        return this;
    }
}

class MediatorTest{
    public static void main(String[] args) {
        Me me1 = Me.create().setName("h1").setMessage("hello m2");
        Me me2 = Me.create().setName("h2").setMessage("hello m1");

        System.out.println("第一种 --- ");
        me1.sendMessage();
        me2.sendMessage();

        System.out.println("第二种 --- ");
        MediatorImpl1 mediatorImpl1 = new MediatorImpl1();
        System.out.println("me1 发送：");
        me1.sendMessage1(mediatorImpl1);
        System.out.println("me2 接收：");
        me2.receiveMessage1(mediatorImpl1);
    }
}


