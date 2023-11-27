package bingsearchtest;

import core.BaseTest;
import org.example.pages.BingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BingSearchByTermTest extends BaseTest {

    @Test
    public void resultFound_when_searchTermProvided() {
        BingPage bingHomePage = new BingPage(driver);
        bingHomePage.navigateToBing();
        bingHomePage.acceptConsent();

        String searchTerm = "Telerik Academy Alpha";
        String expectedTitle = "IT Career Start in 6 Months - Telerik Academy Alpha";

        bingHomePage.search(searchTerm);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=' b_topTitle']")));

        WebElement firstResultTitleElement = driver.findElement(By.xpath("//h2[@class=' b_topTitle']"));
        String firstResultTitle = firstResultTitleElement.getText();

        Assertions.assertEquals(expectedTitle, firstResultTitle, "Search result title does not match. Expected: " + expectedTitle + ", Actual: " + firstResultTitle);
    }
}
