package javapattern.bridge;

import javapattern.util.BeanUtils;
import javapattern.util.ConfigUtils;
import javapattern.util.XMLUtils;

/**
 * @author hbw
 */
public interface Bridge {

    /**
     * get converter
     * @param converter
     * @return
     */
    static Converter getConverter(
            String converter) {

        return getBean(converter);
    }

    /**
     * get db
     * @param db
     * @return
     */
    static Db getDb(
            String db) {

        return getBean(db);
    }

    /**
     * get ff
     * @param ff
     * @return
     */
    static Ff getFf(
            String ff) {

        return getBean(ff);
    }

    /**
     * get bean
     * @param key
     * @param <T>
     * @return
     */
    static <T> T getBean(
            String key) {

        return BeanUtils.getBean(XMLUtils.bridgeProp(ConfigUtils.getProp(key)));
    }
}
