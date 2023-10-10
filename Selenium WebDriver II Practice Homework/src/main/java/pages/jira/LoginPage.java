package pages.jira;

import org.openqa.selenium.WebDriver;

import static com.jira.testframework.Utils.getConfigPropertyByKey;

public class LoginPage extends BaseJiraPage {

    public LoginPage(WebDriver driver) {
        super(driver, "jira.loginPage");
    }

    public void loginUser() {
        String username = getConfigPropertyByKey("jira.users.email");
        String password = getConfigPropertyByKey("jira.users.password");

        navigateToPage();
        assertPageNavigated();

        actions.waitForElementVisible("jira.loginPage.email");
        actions.typeValueInField(username, "jira.loginPage.email");

        actions.waitForElementVisible("jira.loginPage.continueButton");
        actions.clickElement("jira.loginPage.continueButton");

        actions.waitForElementVisible("jira.loginPage.password");
        actions.typeValueInField(password, "jira.loginPage.password");

        actions.waitForElementVisible("jira.loginPage.loginButton");
        actions.clickElement("jira.loginPage.loginButton");

    }
}
