package designpattern.chain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : hbw
 * @desctiption : 请求与处理者的解耦合。请求一次，处理者会根据一定顺序链式依次调用，直到处理完毕。
 * @date : 2020-06-18 09:56
 */
public class ChainDemo {
}

// 处理者
interface Handler{
    int LEVEL_1 = 1;
    int LEVEL_2 = 2;
    int LEVEL_3 = 3;
    void play(String message);
    boolean doPlay(int level, String message);
}

abstract class AbstractHandler implements Handler{
    protected int level;
    public boolean doPlay(int level, String message){
        if(this.level <= level){
            play(message);
            return true;
        }
        return false;
    }
}

class Handler1Impl extends AbstractHandler{
    public Handler1Impl(int level){
        this.level = level;
    }

    @Override
    public void play(String message) {
        System.out.println("Handler1::play " + message);
    }
}
class Handler2Impl extends AbstractHandler{
    public Handler2Impl(int level){
        this.level = level;
    }

    @Override
    public void play(String message) {
        System.out.println("Handler2::play " + message);
    }
}
class Handler3Impl extends AbstractHandler{
    public Handler3Impl(int level){
        this.level = level;
    }

    @Override
    public void play(String message) {
        System.out.println("Handler3::play " + message);
    }
}

// 生成职责链
class ChainBuilder{
    List<Handler> chainList;
    private ChainBuilder(){
        chainList = new LinkedList<>();
    }

    public ChainBuilder addNext(Handler handler){
        chainList.add(handler);
        return this;
    }

    public static ChainBuilder create(){
        return new ChainBuilder();
    }

    public List<Handler> build(){
        return chainList;
    }
}

// 职责链调用 提供了3种实现方式，可以根据需求使用
class ChainHandler{
    // 通过map可以依次打印出每次调用的结果
    public static void handle1(List<Handler> handlerList, int level, String message){
        handlerList.stream().map(handler -> handler.doPlay(level, message))
                .collect(Collectors.toList()).forEach(System.out::println);

    }

    // 如果调用过程中有一次失败，就认为是整体失败，可用map reduce输出最终结果
    public static void handle2(List<Handler> handlerList, int level, String message){
        System.out.println(handlerList.stream().map(handler -> handler.doPlay(level, message))
                .reduce((a, b) -> a && b)
                .get());
    }

    // 如果失败，就停止
    public static void handle3(List<Handler> handlerList, int level, String message){
        Iterator<Handler> it = handlerList.iterator();
        while(it.hasNext()){
            boolean b = it.next().doPlay(level, message);
            if(!b) return;
        }
    }
}



class testChain{
    public static void main(String[] args) {
        List<Handler> chainList = ChainBuilder.create()
                .addNext(new Handler1Impl(Handler.LEVEL_1))
                .addNext(new Handler2Impl(Handler.LEVEL_2))
                .addNext(new Handler3Impl(Handler.LEVEL_3))
                .build();

        println(1, 1);
        ChainHandler.handle1(chainList, 1, "level 1");
        println(1, 2);
        ChainHandler.handle1(chainList, 2, "level 2");
        println(1, 3);
        ChainHandler.handle1(chainList, 3, "level 3");

        println(2, 3);
        ChainHandler.handle2(chainList, 3, "level 3");
        println(2, 2);
        ChainHandler.handle2(chainList, 2, "level 2");
        println(2, 1);
        ChainHandler.handle2(chainList, 1, "level 1");

        println(3, 1);
        ChainHandler.handle3(chainList, 1, "level 1");
        println(3, 2);
        ChainHandler.handle3(chainList, 2, "level 2");
        println(3, 3);
        ChainHandler.handle3(chainList, 3, "level 3");
    }

    // 一种桥接模式的运用
    public static void println(int n, int m){
        String n1 = "第一种处理方式";
        String n2 = "第二种处理方式";
        String n3 = "第三种处理方式";

        String m1 = " level 1:";
        String m2 = " level 2:";
        String m3 = " level 3:";

        String nn = getString(n, n1, n2, n3);

        String mm = getString(m, m1, m2, m3);

        System.out.println(nn + mm);
    }

    private static String getString(int n, String n1, String n2, String n3) {
        String nn = null;
        switch (n) {
            case 1:
                nn = n1;
                break;
            case 2:
                nn = n2;
                break;
            case 3:
                nn = n3;
                break;
        }
        return nn;
    }
}
