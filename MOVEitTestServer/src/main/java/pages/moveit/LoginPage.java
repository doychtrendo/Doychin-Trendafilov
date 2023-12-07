package pages.moveit;

import com.moveit.testframework.Utils;
import com.moveit.testframework.utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.moveit.testframework.utils.Constants.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver, LOGIN_PAGE);
    }

    public void login(String username, String password) {
        actions.typeValueInField(Utils.getConfigPropertyByKey(username), LOGIN_USERNAME_FIELD_PATH);
        actions.typeValueInField(Utils.getConfigPropertyByKey(password), LOGIN_PASSWORD_FIELD_PATH);
        actions.clickElement(LOGIN_BUTTON_PATH);
    }

    public void logout() {
        actions.clickElement(LOGOUT_BUTTON);
    }

    @Override
    public void assertPageNavigated() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(URL_ERROR_MESSAGE + currentUrl + EXPECTED_URL_MESSAGE + Utils.getConfigPropertyByKey(LOGIN_PAGE),
                currentUrl.contains(Utils.getConfigPropertyByKey(LOGIN_PAGE)));
    }

    public void assertLoginPageMessage() {
        actions.assertElementPresent(Constants.LOGIN_SECURE_MESSAGE);
    }


    public void assertPasswordFieldVisible() {
        actions.assertElementPresent(LOGIN_PASSWORD_FIELD_PATH);
    }

    public void assertUsernameFieldVisible() {
        actions.assertElementPresent(LOGIN_USERNAME_FIELD_PATH);
    }

    public void assertLoginButtonVisible() {
        actions.assertElementPresent(LOGIN_BUTTON_PATH);
    }

    public void assertLoginErrorMessage() {
        actions.assertElementPresent(Constants.LOGIN_ERROR_MESSAGE);
    }

}
