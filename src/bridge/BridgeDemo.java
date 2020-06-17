package bridge;

/**
 * @author : hbw
 * @desctiption : 搭建一个接口互通的平台(桥)，以便接口之间实现多维多样性的组合关系
 * @date : 2020-06-17 11:29
 */
public class BridgeDemo {
}

interface Sub{
    String sub(String content);
}

interface Content{
    String content();
}

interface Bridge{
    void setSub(Sub sub);
    void setContent(Content content);
    void play();
}

abstract class AbstractBridge implements Bridge{
    Content content;
    Sub sub;
    public void setContent(Content content){
        this.content = content;
    }
    public void setSub(Sub sub){ this.sub = sub; }
}

class BridgeImpl extends AbstractBridge{
    @Override
    public void play() {
        System.out.println(sub.sub(content.content()));
    }
}

class Sub1Impl implements Sub{
    @Override
    public String sub(String content) {
       return "Sub1::"+content;
    }
}

class Sub2Impl implements Sub{
    @Override
    public String sub(String content) {
        return "Sub2::"+content;
    }
}

class Sub3Impl implements Sub{
    @Override
    public String sub(String content) {
        return "Sub3::"+content;
    }
}

class Content1Impl implements Content{
    @Override
    public String content() {
        return "content1";
    }
}

class Content2Impl implements Content{
    @Override
    public String content() {
        return "content2";
    }
}

class Content3Impl implements Content{
    @Override
    public String content() {
        return "content3";
    }
}

class testBridge{
    public static void main(String[] args) {
        Bridge bridge = new BridgeImpl();
        Sub sub1 = new Sub1Impl();
        Content content1 = new Content1Impl();
        Sub sub2 = new Sub2Impl();
        Content content2 = new Content2Impl();
        Sub sub3 = new Sub3Impl();
        Content content3 = new Content3Impl();

        play(bridge, sub1, content1);
        play(bridge, sub2, content2);
        play(bridge, sub3, content3);
        play(bridge, sub1, content2);
        play(bridge, sub1, content3);
        play(bridge, sub2, content1);
        play(bridge, sub2, content3);
        play(bridge, sub3, content1);
        play(bridge, sub3, content2);
    }

    public static void play(Bridge bridge, Sub sub, Content content){
        bridge.setSub(sub);
        bridge.setContent(content);
        bridge.play();
    }
}
