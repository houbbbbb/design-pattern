package javapattern.flyweight;

/**
 * @author hbw
 */
public class Animation
        implements Material {

    @Override
    public String category() {

        return "动画";
    }

    @Override
    public void opt(
            Coordinate coordinate,
            Integer size) {

        System.out.println("类型：" + category()
                + " 位置：(" + coordinate.getX() + ", " + coordinate.getY() + ")"
                + "大小：" + size);
    }
}
