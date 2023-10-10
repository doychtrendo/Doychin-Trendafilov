package googlesearchtest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchByTermTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void classSetUp() {
        //set up browser
        driver = new ChromeDriver();

        //navigate to bing.com
        driver.get("https://www.google.com");

        //agree to consent
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='L2AGLb']")));
        acceptButton.click();
    }

    @AfterAll
    public static void classTearDown() {
        //close the browser
        driver.close();
    }

    @BeforeEach
    public void testSetUp() {
        //navigate to google.com
        driver.get("https://www.google.com");
    }

    @Test
    public void resultFound_when_searchTermProvided() {
        String searchTerm = "Telerik Academy Alpha";
        String expectedTitle = "IT Career Start in 6 Months - Telerik Academy Alpha";

        //type text in search field
        WebElement searchField = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchField.sendKeys(searchTerm);

        //click search button
        WebElement searchButton = driver.findElement(By.xpath("(//input[@type='submit' and @name='btnK'])[2]"));
        searchButton.click();

        //wait for search results
        WebElement firstResultTitleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a/h3)[1]")));

        //get the text for the first result
        String firstResultTitle = firstResultTitleElement.getText();

        //validate the title of the first result
        Assertions.assertEquals(expectedTitle, firstResultTitle, "Search result title does not match. Expected: " + expectedTitle + ", Actual: " + firstResultTitle);

    }

}
