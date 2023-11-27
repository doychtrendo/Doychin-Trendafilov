package googlesearchtest;

import core.BaseTest;
import org.example.pages.GooglePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchByTermTest extends BaseTest {

    @Test
    public void resultFound_when_searchTermProvided() {
        GooglePage googleHomePage = new GooglePage(driver);
        googleHomePage.navigateToGoogle();
        googleHomePage.acceptConsent();

        String searchTerm = "Telerik Academy Alpha";
        String expectedTitle = "IT Career Start in 6 Months - Telerik Academy Alpha";

        googleHomePage.search(searchTerm);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a/h3)[1]")));

        WebElement firstResultTitleElement = driver.findElement(By.xpath("(//a/h3)[1]"));
        String firstResultTitle = firstResultTitleElement.getText();

        Assertions.assertEquals(expectedTitle, firstResultTitle, "Search result title does not match. Expected: " + expectedTitle + ", Actual: " + firstResultTitle);
    }
}
