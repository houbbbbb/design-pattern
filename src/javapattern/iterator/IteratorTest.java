package javapattern.iterator;

import org.junit.Test;

/**
 * @author hbw
 */
public class IteratorTest {

    @Test
    public void test() {

        Students students = new ConcreteStudents();

        students.add(new Student(1L, 13, "hello"))
                .add(new Student(2L, 3, "me"))
                .add(new Student(3L, 5, "good"));

        IIterator<Student> studentIIterator = students.iterator();

        while (studentIIterator.hasNext()) {

            System.out.println(studentIIterator.next());
        }
    }
}
