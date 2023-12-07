package com.moveit.testframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomWebDriverManager {

    public enum CustomWebDriverManagerEnum {
        INSTANCE;
        private WebDriver driver = setupBrowser();

        public void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }

        public WebDriver getDriver() {
            if (driver == null) {
                driver = setupBrowser();
            }
            return driver;
        }

        private WebDriver setupBrowser() {
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            this.driver = driver;
            return driver;
        }
    }
}
