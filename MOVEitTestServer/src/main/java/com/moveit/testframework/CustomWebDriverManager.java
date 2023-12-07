package com.moveit.testframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomWebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
