package javapattern.util;

import javapattern.builder.BuilderVO;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 86136
 */
public class XMLUtils {

    private XMLUtils() {}

    private static final Map<Type, Element> MAP;

    static {

        MAP = new ConcurrentHashMap<>();

        MAP.put(Type.SIMPLE_FACTORY, getRoot("/simple-factory.xml"));

        MAP.put(Type.FACTORY_METHOD, getRoot("/factory-method.xml"));

        MAP.put(Type.ABSTRACT_FACTORY, getRoot("/abstract-factory.xml"));

        MAP.put(Type.BUILDER, getRoot("/builder.xml"));

        MAP.put(Type.ADAPTER, getRoot("/adapter.xml"));

        MAP.put(Type.BRIDGE, getRoot("/bridge.xml"));
    }

    public static String bridgeProp(String name) {

        return beanClazzProp(name, Type.BRIDGE);
    }

    public static String adapterProp(String name) {

        return beanClazzProp(name, Type.ADAPTER);
    }

    public static BuilderVO builderProp(String name) {

        Element root = MAP.get(Type.BUILDER);

        List<Element> elements = root.elements();

        for (Element element : elements) {

            if (equalsName(name, element)) {

                BuilderVO builderVO = new BuilderVO();

                String classname = stringClass(element);

                builderVO.setClassname(classname);

                List<Element> elementList = element.elements();

                for (Element element1 : elementList) {

                    if(equalsName("menu", element1)) {
                        builderVO.setMenu(booleanValue(element1));
                    } else if (equalsName("list", element1)) {
                        builderVO.setList(booleanValue(element1));
                    } else if (equalsName("win", element1)) {
                        builderVO.setWin(booleanValue(element1));
                    } else if (equalsName("bar", element1)) {
                        builderVO.setBar(booleanValue(element1));
                    }
                }

                return builderVO;
            }
        }

        throw new RuntimeException("该类不存在");
    }

    private static String stringValue(Element element) {

        return element.attributeValue("value");
    }

    private static String stringClass(Element element) {

        return element.attributeValue("class");
    }

    private static boolean booleanValue(Element element) {

        return Boolean.parseBoolean(stringValue(element));
    }

    private static boolean equalsName(String name, Element element) {

        return name.equals(element.attributeValue("name"));
    }

    public static String abstractFactoryProp(String name) {

        return beanClazzProp(name, Type.ABSTRACT_FACTORY);
    }

    public static String simpleFactoryProp(String name) {

        return beanClazzProp(name, Type.SIMPLE_FACTORY);
    }

    public static String factoryMethodProp(String name) {

        return beanClazzProp(name, Type.FACTORY_METHOD);
    }

    private static String beanClazzProp(String name, Type type) {

        Element root = MAP.get(type);

        List<Element> elements = root.elements();

        for (Element element : elements) {

            if (equalsName(name, element)) {

                return stringClass(element);
            }
        }

        return null;

    }

    private static Element getRoot(String filePath) {

        try {
            InputStream in = XMLUtils.class.getResourceAsStream(filePath);

            SAXReader saxReader = new SAXReader();

            Document doc = saxReader.read(in);

            return doc.getRootElement();
        } catch (Exception e) { e.printStackTrace(); }

        return null;
    }

    enum Type {

        /**
         * 简单工厂方法
         */
        SIMPLE_FACTORY,

        /**
         * 工厂方法
         */
        FACTORY_METHOD,

        /**
         * 抽象工厂
         */
        ABSTRACT_FACTORY,

        /**
         * 构建者
         */
        BUILDER,

        /**
         * 适配器
         */
        ADAPTER,

        /**
         * bridge
         */
        BRIDGE,

        /**
         * 代理
         */
        PROXY
    }


    public static void main(String[] args) throws Exception {

        System.out.println(simpleFactoryProp("square"));

        System.out.println(builderProp("full"));
    }
}
