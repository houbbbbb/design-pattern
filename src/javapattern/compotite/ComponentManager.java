package javapattern.compotite;

/**
 * @author hbw
 */
public interface ComponentManager {

    /**
     * 增
     * @param component
     */
    void add(
            Component component);

    /**
     * 删
     * @param component
     */
    void remove(
            Component component);

    /**
     * 删
     * @param i
     */
    void remove(
            Integer i);

    /**
     * 查
     * @param i
     * @return
     */
    Component getChild(
            Integer i);
}
