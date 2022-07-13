package javapattern.visitor;

/**
 * @author hbw
 */
public class ScientificResearchAwardsVisitor
        implements Visitor {

    @Override
    public void visit(Teacher teacher) {

        if (teacher.getNum() > 10) {

            System.out.println("教师 " + teacher.getName()
                    + " 发表论文 " + teacher.getNum() + " 篇 "
                    + "获得科研奖");
        }
    }

    @Override
    public void visit(Student student) {

        if (student.getNum() > 2) {

            System.out.println("学生 " + student.getName()
                    + " 发表论文 " + student.getNum() + " 篇 "
                    + "获得科研奖");
        }
    }
}
