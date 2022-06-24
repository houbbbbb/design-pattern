package javapattern.interpret;

/**
 * @author hbw
 */
public class RangeExpression
        implements Expression {

    private Expression srcDbExpression;
    private Expression destDbExpression;

    public RangeExpression(
            Expression srcDbExpression,
            Expression destDbExpression) {

        this.srcDbExpression = srcDbExpression;
        this.destDbExpression = destDbExpression;
    }

    @Override
    public void interpret(
            Context context) {


    }
}
