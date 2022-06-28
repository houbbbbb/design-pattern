package javapattern.iterator;

import java.util.*;

/**
 * @author hbw
 */
public class ConcreteStudents
        implements Students {

    private final List<Student> studentList;

    public ConcreteStudents() {

        this.studentList = new ArrayList<>();
    }

    @Override
    public Students add(
            Student student) {

        this.studentList.add(student);

        return this;
    }

    public List<Student> getStudentList() {

        return studentList;
    }

    @Override
    public IIterator<Student> iterator() {

        return new StudentIterator();
    }

    private class StudentIterator
            implements IIterator<Student> {

        private Integer cursor = -1;
        private final List<Student> itrStudent;

        public StudentIterator() {

            this.itrStudent = Arrays.asList(new Student[studentList.size()]);

            Collections.copy(this.itrStudent, studentList);

            this.itrStudent.sort(Comparator
                    .comparing(Student::getAge)
                    .reversed());
        }

        @Override
        public boolean hasNext() {

            return this.itrStudent.size() > cursor + 1;
        }

        @Override
        public Student next() {

            return this.itrStudent.get((++cursor));
        }
    }
}
