package sausedemotests;

import core.BaseTest;
import org.example.BrowserTypes;
import org.example.pages.LoginPage;
import org.example.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    private static LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driver = startBrowser(BrowserTypes.CHROME);
        loginPage = new LoginPage(driver);
        driver.get(Constants.BASE_URL);
    }

    @AfterEach
    public void teardown() {
        if (loginPage != null) {
            loginPage.logout();
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        loginPage.login(Constants.STANDARD_USER_USERNAME, Constants.STANDARD_USER_PASSWORD);
        loginPage.assertUserIsAuthenticated();
    }

}
