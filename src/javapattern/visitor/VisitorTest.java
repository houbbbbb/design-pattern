package javapattern.visitor;

import org.junit.Test;

/**
 * @author hbw
 */
public class VisitorTest {

    @Test
    public void test() {

        Members members = new Members();

        members.addElement(new Student(3, "student", 98.0));
        members.addElement(new Teacher(11, "teacher", 99.0));

        members.accept(new BlueChipAwardVisitor());
        members.accept(new ScientificResearchAwardsVisitor());
    }
}
