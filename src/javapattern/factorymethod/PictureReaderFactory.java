package javapattern.factorymethod;

/**
 * @author 86136
 */
public interface PictureReaderFactory {

    /**
     * 创建图片阅读器
     * @return
     */
    PictureReader createPicReader();
}
