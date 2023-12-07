package test.cases.moveit;

import com.moveit.testframework.Utils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = Utils.getWebDriver();
    }

    @AfterClass
    public static void tearDown() {
        Utils.tearDownWebDriver();
    }
}

