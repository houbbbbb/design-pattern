package javapattern.visitor;

/**
 * @author hbw
 */
public class Teacher
        implements Element {

    private Integer num;
    private String name;
    private Double grade;

    public Teacher(
            Integer num,
            String name,
            Double grade) {

        this.num = num;
        this.name = name;
        this.grade = grade;
    }

    public Double getGrade() {

        return grade;
    }

    public Integer getNum() {

        return num;
    }

    public String getName() {

        return name;
    }

    @Override
    public void accept(
            Visitor visitor) {

        visitor.visit(this);
    }
}
