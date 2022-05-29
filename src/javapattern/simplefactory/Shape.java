package javapattern.simplefactory;

import com.sun.istack.internal.NotNull;
import javapattern.util.BeanUtils;
import javapattern.util.PropertyUtils;

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
    static Shape getInstance(String name) {

        try {
            return BeanUtils.getBean(PropertyUtils
                    .getSimpleFactoryProperty(name));
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
