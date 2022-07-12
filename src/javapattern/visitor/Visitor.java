package javapattern.visitor;

/**
 * @author hbw
 */
public interface Visitor {

    /**
     * @param concreteElementA
     */
    void visit(
            ConcreteElementA concreteElementA);

    /**
     * @param concreteElementB
     */
    void visit(
            ConcreteElementB concreteElementB);
}
