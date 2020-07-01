package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hbw
 * @desctiption : 相同功能机构的分层管理
 * 保证客户端调用单对象与组合对象的一致性。适用：具有相同功能的树形母子机构。
 * @date : 2020-06-16 11:04
 */
public class CompositeDemo {
}
// 定义功能接口
interface Component {
    void sayHello();
}
// 叶子节点
class Leaf implements Component{
    private String name;
    public Leaf(String name){
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println(name);
    }
}
// 合成节点
class Composite implements Component{
    private String name;
    public Composite(String name){
        this.name = name;
    }
    List<Component> componentList = new ArrayList<>();
    @Override
    public void sayHello() {
        System.out.println(name);
    }

    public void addPart(Component component){
        componentList.add(component);
    }
}
class TestClass{
    public static void main(String[] args){
        Composite composite = new Composite("总部");
        Composite part1 = new Composite("分部1");
        part1.addPart(new Leaf("小分部1"));
        composite.addPart(part1);
        composite.addPart(new Leaf("分部2"));
        composite.addPart(new Leaf("分部3"));

        composite.sayHello();
        composite.componentList.forEach(
                component -> {
                    component.sayHello();
                    if(component instanceof Composite){
                        ((Composite) component).componentList.forEach(Component::sayHello);
                    }
                }
        );

    }
}
