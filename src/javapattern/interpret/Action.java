package javapattern.interpret;

/**
 * @author hbw
 */
public class Action
        implements Expression {

    @Override
    public void interpret(
            Context context) {

        System.out.println(context.word());
    }
}
