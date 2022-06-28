package javapattern.iterator;

/**
 * @author hbw
 */
public interface IIterator<T> {

    /**
     * 是否包含下一个
     * @return
     */
    boolean hasNext();

    /**
     * 下一个
     * @return
     */
    T next();
}
