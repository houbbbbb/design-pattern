package javapattern.bridge;

/**
 * @author hbw
 */
public interface Converter {

    /**
     * set db
     * @param db
     * @return
     */
    Converter setDb(
            Db db);

    /**
     * set ff
     * @param ff
     * @return
     */
    Converter setFf(
            Ff ff);

    /**
     * convert
     */
    void convert();
}
