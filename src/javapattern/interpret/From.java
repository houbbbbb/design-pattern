package javapattern.interpret;

/**
 * @author hbw
 */
public class From
        implements Expression {


    @Override
    public void interpret(
            Context context) {

        System.out.println(context.word());
    }
}
