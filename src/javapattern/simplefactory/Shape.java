package javapattern.simplefactory;

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
     * 工厂方法，获取实体
     * @param type
     * @return
     */
    static Shape getInstance(
            Type type) {

        switch (type) {
            case CIRCLE: return new Circle();
            case SQUARE: return new Square();
            case TRIANGLE: return new Triangle();
            default: throw new UnsupportedOperationException();
        }
    }


    enum Type {
        /**
         * 圆形
         */
        CIRCLE,
        /**
         * 方形
         */
        SQUARE,
        /**
         * 三角形
         */
        TRIANGLE
    }

    class UnsupportedShapeException
            extends RuntimeException {

        public UnsupportedShapeException() {
            super("不支持的类型");
        }
    }
}
