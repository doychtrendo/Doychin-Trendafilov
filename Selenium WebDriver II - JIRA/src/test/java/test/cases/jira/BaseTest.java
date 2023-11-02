package test.cases.jira;

import com.jira.testframework.UserActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.jira.LoginPage;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeAll
    public static void setUp() {
        UserActions.loadBrowser("jira.homePage");
    }

    @AfterAll
    public static void tearDown() {
        UserActions.quitDriver();
    }

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser();
    }
}