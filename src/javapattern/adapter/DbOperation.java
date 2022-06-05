package javapattern.adapter;

import javapattern.util.BeanUtils;
import javapattern.util.ConfigUtils;
import javapattern.util.XMLUtils;

/**
 * @author 86136
 */
public interface DbOperation {

    void save(
            UserEntity userEntity);

    static DbOperation getInstance(String name) {

        return BeanUtils.getBean(XMLUtils.adapterProp(ConfigUtils
                .getProp(name)));
    }
}
