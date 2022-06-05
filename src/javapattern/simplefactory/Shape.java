package javapattern.simplefactory;

import javapattern.util.BeanUtils;
import javapattern.util.ConfigUtils;
import javapattern.util.XMLUtils;

/**
 * @author 86136
 */
public interface Shape {

    /**
     * 绘制
     */
    void drawl();

    /**
     * 擦除
     */
    void erase();

    /**
     * 获取实体对象
     * @param name
     * @return
     */
    static Shape getInstance(
            String name) {

        try {
            return BeanUtils.getBean(XMLUtils.simpleFactoryProp(ConfigUtils
                    .getProp(name)));
        } catch (Exception e) {
            throw new UnsupportedShapeException();
        }
    }


    class UnsupportedShapeException
            extends RuntimeException {

        public UnsupportedShapeException() {

            super("不支持的类型");
        }
    }
}
