package javapattern.interpret;

public class Db
        implements Expression {


    @Override
    public void interpret(
            Context context) {

        System.out.println(context.word());
    }
}
