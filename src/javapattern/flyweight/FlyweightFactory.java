package javapattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hbw
 */
public class FlyweightFactory {

    private FlyweightFactory() {}

    private static final Map<Type, Material> MATERIAL_MAP;

    static {

        MATERIAL_MAP = new ConcurrentHashMap<>();

        MATERIAL_MAP.put(Type.IMAGE, new Image());

        MATERIAL_MAP.put(Type.ANIMATION, new Animation());

        MATERIAL_MAP.put(Type.VIDEO, new Video());
    }

    public static Material getMaterial(
            Type type) {

        return MATERIAL_MAP.get(type);
    }

    public enum Type {

        /**
         * 图片
         */
        IMAGE,

        /**
         * 视频
         */
        VIDEO,

        /**
         * 动画
         */
        ANIMATION
    }
}
