package test.cases.moveit;

import com.moveit.testframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static com.moveit.testframework.utils.Constants.BING_HOME_PAGE;

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
