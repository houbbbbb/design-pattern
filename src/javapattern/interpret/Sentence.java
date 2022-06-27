package javapattern.interpret;

/**
 * @author hbw
 */
public class Sentence
        implements Expression {

    private Expression action;
    private Expression table;
    private Expression db;
    private Expression from;
    private Expression to;

    public Sentence(
            Expression action,
            Expression table,
            Expression db,
            Expression from,
            Expression to) {

        this.action = action;
        this.table = table;
        this.db = db;
        this.from = from;
        this.to = to;
    }

    @Override
    public void interpret(
            Context context) {

        action.interpret(context);

        table.interpret(context);

        from.interpret(context);

        db.interpret(context);

        to.interpret(context);

        db.interpret(context);
    }
}
