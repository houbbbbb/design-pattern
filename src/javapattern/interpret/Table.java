package javapattern.interpret;

/**
 * @author hbw
 */
public class Table
        implements Expression {

    @Override
    public void interpret(
            Context context) {

        System.out.println(context.word());
    }
}
