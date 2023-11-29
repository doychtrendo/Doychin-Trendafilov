package pages.bing;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static com.telerikacademy.testframework.utils.Constants.BING_HOME_PAGE;
import static com.telerikacademy.testframework.utils.Constants.BING_RESULTS_PAGE_FIRST_RESULT;

public class BingResultsPage extends BasePage {

    public BingResultsPage(WebDriver driver) {
        super(driver, BING_HOME_PAGE);
    }

    public void assertResultIsPresent(String resultTitle) {
        actions.assertElementPresent(BING_RESULTS_PAGE_FIRST_RESULT);
        actions.assertElementAttribute(BING_RESULTS_PAGE_FIRST_RESULT, "innerText", resultTitle);
    }
}
