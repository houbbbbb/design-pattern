package javapattern.factorymethod;

import javapattern.simplefactory.Shape;
import javapattern.util.BeanUtils;
import javapattern.util.XMLUtils;

/**
 * @author 86136
 */
public interface PictureReaderFactory {

    /**
     * 创建图片阅读器
     * @return
     */
    PictureReader createPicReader();

    /**
     * 获取工厂
     * @param name
     * @return
     */
    static PictureReaderFactory getInstance(
            String name) {

        try {
            return BeanUtils.getBean(XMLUtils.factoryMethodProp(name));
        } catch (Exception e) {
            throw new UnsupportedFactoryException();
        }
    }


    class UnsupportedFactoryException
            extends RuntimeException {

        public UnsupportedFactoryException() {

            super("不支持的类型");
        }
    }
}
