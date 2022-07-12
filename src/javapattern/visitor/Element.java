package javapattern.visitor;

/**
 * @author hbw
 */
public interface Element {

    /**
     * acc
     * @param visitor
     */
    void accept(
            Visitor visitor);
}
