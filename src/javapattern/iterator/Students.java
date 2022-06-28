package javapattern.iterator;

/**
 * @author hbw
 */
public interface Students {

    /**
     * 创建迭代器
     * @return
     */
    IIterator<Student> iterator();

    /**
     * 增加学生
     * @param student
     */
    Students add(
            Student student);
}
