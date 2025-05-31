package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String configFilePath = "configuration.properties";
    private static Properties properties = new Properties();
    static {
        try {
            FileInputStream file = new FileInputStream(configFilePath);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveProperties() {
        try (FileOutputStream outputFile = new FileOutputStream(configFilePath)) {
            properties.store(outputFile, "Updated Dynamic Properties");
        } catch (IOException e) {
            throw new RuntimeException("Error while updating configuration.properties file", e);
        }
    }

    public static void saveToConfig(String key, String value) {
        properties.setProperty(key, value);
        saveProperties();
    }

    public static void updateProperty(String keyword) {
        switch (keyword) {
            case "movieID":
                String movieID="";
                properties.setProperty(keyword, movieID);
                break;
            default:
                throw new IllegalArgumentException("Unsupported property key: " + keyword);
        }
        saveProperties();
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}