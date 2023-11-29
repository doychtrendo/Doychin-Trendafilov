package test.cases.bing;

import com.telerikacademy.testframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static com.telerikacademy.testframework.utils.Constants.BING_HOME_PAGE;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeClass
    public static void setUp() {
        UserActions.loadBrowser(BING_HOME_PAGE);
    }

    @AfterClass
    public static void tearDown() {
        UserActions.quitDriver();
    }
}
