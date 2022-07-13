package javapattern.visitor;

/**
 * @author hbw
 */
public class BlueChipAwardVisitor
        implements Visitor {

    @Override
    public void visit(
            Teacher teacher) {

        if (teacher.getGrade() >= 90) {

            System.out.println("教师 " + teacher.getName()
                    + " 成绩 " + teacher.getGrade() + " 分 "
                    + "获得绩优奖");
        }
    }

    @Override
    public void visit(
            Student student) {


        if (student.getGrade() >= 90) {

            System.out.println("学生 " + student.getName()
                    + " 成绩 " + student.getGrade() + " 分 "
                    + "获得绩优奖");
        }
    }
}
