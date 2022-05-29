package javapattern.util;

import org.yaml.snakeyaml.Yaml;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 86136
 */
public class PropertyUtils {

    private PropertyUtils() {}

    private static final Map<Type, Prop> MAP;

    static {
        MAP = new ConcurrentHashMap<>();
        MAP.put(Type.SIMPLE_FACTORY, Prop
                .getInstance("/simplefactory.yml", new Yaml()));

        MAP.forEach((k, v) -> TryUtils.exc(() ->
                v.o = v.yaml.load(PropertyUtils.class
                        .getResourceAsStream(v.path))));
    }

    public static String simpleFactoryProp(String key) {

        return ((Map<String, String>)MAP.get(Type.SIMPLE_FACTORY).o).get(key);
    }

    enum Type {
        /**
         * 简单工厂方法
         */
        SIMPLE_FACTORY
    }

    static class Prop {

        static Prop getInstance(
                String path,
                Yaml yaml) {

            return new Prop(path, yaml);
        }

        private Prop(
                String path,
                Yaml yaml) {

            this.path = path;
            this.yaml = yaml;
        }

        private String path;
        private Yaml yaml;
        private Object o;
    }
}
