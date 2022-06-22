package javapattern.interpret;

/**
 * @author hbw
 */
public interface Expression {

    /**
     * 解释
     * @param context
     */
    void interpret(
            Context context);
}
