package javapattern.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * @author 86136
 */
public class ConfigUtils {

    private static final String POINT = ".";
    private static final String REGEX_POINT = "\\.";
    private static final String CONFIG_PATH = "/config.yml";

    private static final JsonElement CONFIG;

    static {

        Yaml yaml = new Yaml();

        InputStream in = ConfigUtils.class
                .getResourceAsStream(CONFIG_PATH);

        CONFIG = new Gson().toJsonTree(yaml.load(in));
    }

    private ConfigUtils() {}

    public static String getProp(String key) {

        if (!key.contains(POINT)) {
            return CONFIG.getAsJsonObject().get(key).toString();
        }

        if (key.contains(POINT)) {

            String[] keys = key.split(REGEX_POINT);

            JsonElement curr = CONFIG;

            for (String s : keys) {

                curr = curr.getAsJsonObject()
                        .get(s);
            }

            return curr.getAsString();
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println(getProp("simple-factory.shape"));
    }
}
