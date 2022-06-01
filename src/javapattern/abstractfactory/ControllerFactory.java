package javapattern.abstractfactory;

import javapattern.util.BeanUtils;
import javapattern.util.XMLUtils;

/**
 * @author 86136
 */
public interface ControllerFactory {

    /**
     * 通过反射创建工厂
     * @param name
     * @return
     */
    static ControllerFactory getInstance(String name) {

        return BeanUtils.getBean(XMLUtils.abstractFactoryProp(name));
    }

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
