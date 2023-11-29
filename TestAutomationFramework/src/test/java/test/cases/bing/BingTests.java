package test.cases.bing;

import org.junit.Test;
import pages.bing.BingHomePage;
import pages.bing.BingResultsPage;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;
import static com.telerikacademy.testframework.utils.Constants.BING_HOME_PAGE_SEARCH_TEXT;
import static com.telerikacademy.testframework.utils.Constants.BING_RESULTS_PAGE_FIRST_RESULT_TITLE;

public class BingTests extends BaseTest {

    @Test
    public void searchInputVisible_when_homePageNavigated() {

        BingHomePage home = new BingHomePage(actions.getDriver());

        home.navigateToPage();

        home.assertSearchInputVisible();
    }

    @Test
    public void searchResultsVisible_when_termIsSearched() {
        BingHomePage home = new BingHomePage(actions.getDriver());
        home.navigateToPage();

        home.searchAndSubmit(getUIMappingByKey(BING_HOME_PAGE_SEARCH_TEXT));

        BingResultsPage results = new BingResultsPage(actions.getDriver());
        results.assertResultIsPresent(getUIMappingByKey(BING_RESULTS_PAGE_FIRST_RESULT_TITLE));
    }
}
