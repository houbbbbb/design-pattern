package javapattern.visitor;

/**
 * @author hbw
 */
public interface Visitor {

    /**
     * 访问教师
     * @param teacher
     */
    void visit(
            Teacher teacher);

    /**
     * 访问学生
     * @param student
     */
    void visit(
            Student student);
}
