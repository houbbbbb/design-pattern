package javapattern.abstractfactory;

/**
 * @author 86136
 */
public interface ControllerFactory {

    /**
     * 创建界面控制器
     * @return
     */
    InterfaceController createInterfaceController();

    /**
     * 创建操作控制器
     * @return
     */
    OperationController createOperationController();
}
