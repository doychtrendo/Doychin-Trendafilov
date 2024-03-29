package com.moveit.testframework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Utils {

    private static final Properties uiMappings = PropertiesManager.PropertiesManagerEnum.INSTANCE.getUiMappings();
    private static final Properties configProperties = PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties();
    public static final Logger LOGGER = LogManager.getRootLogger();

    public static WebDriver getWebDriver() {
        LOGGER.info("Initializing WebDriver");
        return CustomWebDriverManager.getDriver();
    }

    public static void tearDownWebDriver() {
        LOGGER.info("Quitting WebDriver");
        CustomWebDriverManager.quitDriver();
    }

    public static String getUIMappingByKey(String key) {
        String value = uiMappings.getProperty(key);
        return value != null ? value : key;
    }

    public static String getConfigPropertyByKey(String key) {
        String value = configProperties.getProperty(key);
        return value != null ? value : key;
    }
}
