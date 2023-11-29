package test.cases.trello;

import com.telerikacademy.testframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.trello.LoginPage;

import static com.telerikacademy.testframework.utils.Constants.TRELLO_HOME_PAGE;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeClass
    public static void setUp() {

        UserActions.loadBrowser(TRELLO_HOME_PAGE);

    }

    @AfterClass
    public static void tearDown() {

        UserActions.quitDriver();
    }

    public void login() {

        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser("user");
    }

}
