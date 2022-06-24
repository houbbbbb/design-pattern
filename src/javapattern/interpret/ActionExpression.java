package javapattern.interpret;

/**
 * @author hbw
 */
public class ActionExpression
        implements Expression {

    private Expression typeExpression;

    public ActionExpression(
            Expression typeExpression) {

        this.typeExpression = typeExpression;
    }

    @Override
    public void interpret(
            Context context) {


    }
}
