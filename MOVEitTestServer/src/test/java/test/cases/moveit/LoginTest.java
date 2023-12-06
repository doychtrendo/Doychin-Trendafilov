package test.cases.moveit;

import com.moveit.testframework.Utils;
import com.moveit.testframework.utils.Constants;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.moveit.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setUpTest() {
        driver = Utils.getWebDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
    }

    @AfterEach
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    //MOV-1 [MOVEit-Auth] Verify successful login with valid credentials
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.assertPageNavigated();
        loginPage.assertPasswordFieldVisible();
        loginPage.assertUsernameFieldVisible();
        loginPage.assertLoginButtonVisible();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);
        loginPage.logout();
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(Constants.INVALID_USER_NAME, Constants.INVALID_USER_PASSWORD);
        loginPage.assertLoginErrorMessage();
    }

    @Test
    public void testLogoutFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);
        loginPage.logout();
    }

}
