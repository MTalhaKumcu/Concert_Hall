package com.solvd.persistence.connection;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;


public class DBpropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream stream = DBpropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            PROPERTIES.load(stream);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String get(String driverKey) {
        return PROPERTIES.getProperty(driverKey);
    }
}
