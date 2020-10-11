package com.xevgnov.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PropertyReader {

    private static PropertyReader instance = null;
    private static final Logger LOGGER = Logger.getLogger(PropertyReader.class.getName());
    private final static String APPLICATION_PROPERTIES = "application.properties";
    private final static String TEST_PROPERTIES = "test.properties";
    private final Properties properties = new Properties();

    private PropertyReader(String propertyFile) {
        InputStream inputStream = null;
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            inputStream = classLoader.getResourceAsStream(propertyFile);
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Cannot load properties from file " + propertyFile, e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, e.toString(), e);
                }
            }
        }
    }

    public String getProperty(PropertyOption propertyOption) {
        String propertyValue = properties.getProperty(propertyOption.getName());
        LOGGER.info("Got the property value: " + propertyValue);
        return propertyValue;
    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader(APPLICATION_PROPERTIES);
        }
        return instance;
    }

    public static PropertyReader getTestInstance() {
        if (instance == null) {
            instance = new PropertyReader(TEST_PROPERTIES);
        }
        return instance;
    }

}
