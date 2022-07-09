package javapattern.strategy;

/**
 * @author hbw
 */
public interface Plane {

    /**
     * 类型特点
     */
    void categoryFeature();

    /**
     * 飞机类型
     */
    enum PlaneType {

        /**
         * 直升机
         */
        HELICOPTER("直升机"),

        /**
         * 客机
         */
        AIRPLANE("客机"),

        /**
         * 歼击机
         */
        FIGHTER("歼击机"),

        /**
         * 鹞式战斗机
         */
        HARRIER("鹞式战斗机");

        private String name;

        PlaneType(
                String name) {
            this.name = name;
        }

        public String getName() {

            return name;
        }
    }

    /**
     * 起飞方式
     */
    enum TakeOffType {

        /**
         * 垂直起飞
         */
        VERTICAL_TAKEOFF("垂直起飞"),

        /**
         * 长距离起飞
         */
        LONG_DISTANCE_TAKEOFF("长距离起飞");

        private String name;

        TakeOffType(
                String name) {

            this.name = name;
        }

        public String getName() {

            return name;
        }
    }

    /**
     * 飞行特征
     */
    enum FlyType {

        /**
         * 亚音速飞行
         */
        SUBSONIC_FLY("亚音速飞行"),

        /**
         * 超音速飞行
         */
        SUPERSONIC_FLY("超音速飞行");

        private String name;

        FlyType(
                String name) {

            this.name = name;
        }

        public String getName() {

            return name;
        }
    }
}
