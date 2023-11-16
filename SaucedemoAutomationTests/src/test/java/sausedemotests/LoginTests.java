package sausedemotests;

import core.BaseTest;
import org.example.BrowserTypes;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    private static LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driver = startBrowser(BrowserTypes.CHROME);
        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void teardown() {
        if (loginPage != null) {
            loginPage.logOut();
        }

        if (driver != null) {
            driver.quit();
        }
    }

//test

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        loginPage.logIn("standard_user", "secret_sauce");
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "URL not as expected after login");
    }

}
