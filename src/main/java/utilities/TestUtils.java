package utilities;

import config.ConfigReader;
import java.util.Properties;

public class TestUtils {

    static Properties prop = ConfigReader.initProperties();

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}