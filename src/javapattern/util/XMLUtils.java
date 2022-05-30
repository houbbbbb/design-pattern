package javapattern.util;

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
    }

    public static String simpleFactoryProp(String name) {

        Element root = MAP.get(Type.SIMPLE_FACTORY);

        List<Element> elements = root.elements();

        for (Element element : elements) {

            if (name.equals(element.attributeValue("name"))) {

                return element.attributeValue("class");
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
        SIMPLE_FACTORY
    }


    public static void main(String[] args) throws Exception {

        System.out.println(simpleFactoryProp("square"));
    }
}
