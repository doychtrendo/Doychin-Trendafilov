package googlesearchtest;

import core.BaseTest;
import org.example.pages.GooglePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.utils.Constants.*;

public class GoogleSearchByTermTest extends BaseTest {

    @Test
    public void resultFound_when_searchTermProvided() {
        GooglePage googleHomePage = new GooglePage(driver);
        googleHomePage.navigateToGoogle();
        googleHomePage.acceptConsent();

        googleHomePage.search(SEARCH_TERM);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(GOOGLE_FIRST_RESULT_XPATH)));

        WebElement firstResultTitleElement = driver.findElement(By.xpath(GOOGLE_FIRST_RESULT_XPATH));
        String firstResultTitle = firstResultTitleElement.getText();

        Assertions.assertEquals(EXPECTED_TITLE, firstResultTitle, String.format(TITLE_NOT_MATCH_ERROR, EXPECTED_TITLE, firstResultTitle));
    }
}
