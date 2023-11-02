package sausedemotests;

import core.BaseTest;
import org.example.BrowserTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @BeforeAll
    public static void beforeAllTests() {
        driver = startBrowser(BrowserTypes.CHROME);

        // configure wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // navigate to Saucedemo
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        authenticateWithUser("standard_user", "secret_sauce");

        // assert URL after login
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "URL not as expected");
    }

}
