package javapattern.chainofresposibility;

/**
 * @author hbw
 */
public interface Approver {

    /**
     * 处理
     * @param paramValue
     */
    void process(
            ParamValue paramValue);
}
