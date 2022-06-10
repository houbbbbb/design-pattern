package javapattern.bridge;

/**
 * @author hbw
 */
public class ConverterImpl
        implements Converter {

    private Db db;

    private Ff ff;

    @Override
    public Converter setDb(
            Db db) {

        this.db = db;

        return this;
    }

    @Override
    public Converter setFf(
            Ff ff) {

        this.ff = ff;

        return this;
    }

    @Override
    public void convert() {

        ff.write(db.read());
    }
}
