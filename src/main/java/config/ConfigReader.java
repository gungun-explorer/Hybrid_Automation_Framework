package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties initProperties() {

        Properties prop = new Properties();

        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                prop.load(is);
            } else {
                throw new RuntimeException("Failed to load config.properties from classpath");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config properties from: " + System.getProperty("user.dir") + "/src/main/resources/config.properties", e);
        }

        return prop;
    }
}