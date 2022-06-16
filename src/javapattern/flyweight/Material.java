package javapattern.flyweight;

/**
 * @author hbw
 */
public interface Material {

    /**
     * 类型
     * @return
     */
    String category();

    /**
     * 操作
     * @param coordinate
     * @param size
     */
    void opt(
            Coordinate coordinate,
            Integer size);
}
