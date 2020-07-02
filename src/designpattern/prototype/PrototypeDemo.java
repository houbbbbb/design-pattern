package designpattern.prototype;

/**
 * @author : hbw
 * @desctiption : 通过克隆拷贝一个与原对象内容相同但是地址不同的另一个对象，两者后续操作不会相互影响，克隆对象相当于原对象某一时间点的快照。
 * @date : 2020-07-02 16:44
 */
public class PrototypeDemo {
    public static void main(String[] args) {

        Shape shape = new Shape();
        shape.setName("shape");

        Shape shape1 = shape.getClone();

        System.out.println(shape1.getName());

        shape1.setName("shape1");

        shape.setName("shape2");

        System.out.println(shape.getName() + " --- " + shape1.getName());
    }
}

class Shape implements Cloneable {

    private String name;

    public Shape getClone () {
        try {
            return (Shape)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


