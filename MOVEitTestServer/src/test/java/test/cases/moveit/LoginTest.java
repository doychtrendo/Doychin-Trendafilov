package test.cases.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Test;
import pages.moveit.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    //MOV-1 [MOVEit-Auth] Verify successful login with valid credentials
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.assertPageNavigated();
        loginPage.assertLoginPageMessage();
        loginPage.assertPasswordFieldVisible();
        loginPage.assertUsernameFieldVisible();
        loginPage.assertLoginButtonVisible();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(Constants.INVALID_USER_NAME, Constants.INVALID_USER_PASSWORD);

        loginPage.assertLoginErrorMessage();
    }

}
