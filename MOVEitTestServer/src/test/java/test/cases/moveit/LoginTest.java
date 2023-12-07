package test.cases.moveit;

import com.moveit.testframework.Utils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.moveit.LoginPage;

import static com.moveit.testframework.utils.Constants.*;

public class LoginTest extends BaseTest {

    @BeforeClass
    public static void setUpTest() {
        driver = Utils.getWebDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
    }

    @AfterClass
    public static void tearDownTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    //MOV-1 [MOVEit-Auth] Verify successful login with valid credentials
    public void when_ValidCredentialsProvided_expect_SuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.assertPageNavigated();
        loginPage.assertPasswordFieldVisible();
        loginPage.assertUsernameFieldVisible();
        loginPage.assertLoginButtonVisible();
        loginPage.login(USER_NAME, USER_PASSWORD);
        loginPage.logout();
    }

    @Test
    public void when_InvalidCredentialsProvided_expect_LoginErrorDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(INVALID_USER_NAME, INVALID_USER_PASSWORD);
        loginPage.assertLoginErrorMessage();
    }

    @Test
    public void when_UserLogsOut_expect_RedirectedToLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(USER_NAME, USER_PASSWORD);
        loginPage.logout();
    }

}
