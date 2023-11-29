package pages.bing;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static com.telerikacademy.testframework.utils.Constants.*;

public class BingHomePage extends BasePage {

    public BingHomePage(WebDriver driver) {
        super(driver, BING_HOME_PAGE);
    }

    public void enterSearchTerm(String term) {
        actions.typeValueInField(term, BING_HOME_PAGE_SEARCH_INPUT);
    }

    public void searchAndSubmit(String term) {
        enterSearchTerm(term);
        actions.clickElement(BING_HOME_PAGE_SEARCH_BUTTON);
    }

    public void assertSearchInputVisible() {
        actions.assertElementPresent(BING_HOME_PAGE_SEARCH_INPUT);
    }
}
