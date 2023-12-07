package pages.moveit;

import com.moveit.testframework.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.moveit.testframework.utils.Constants.*;

public class ContactsPage extends BasePage {

    public ContactsPage(WebDriver driver) {
        super(driver, Constants.HOME_PAGE);
    }

    public void openContacts() {
        actions.clickElement(CONTACTS_BUTTON);
    }

    public void clickAddContact() {
        actions.clickElement(ADD_CONTACT_BUTTON);
    }

    public void enterFullName(String fullName) {
        actions.typeValueInField(fullName, CONTACT_NAME);
    }

    public void enterEmailAddress(String emailAddress) {
        actions.typeValueInField(emailAddress, CONTACT_EMAIL);
    }

    public void confirmAddContact() {
        actions.clickElement(ADD_CONTACT_CONFIRMATION_BUTTON);
    }

    public boolean isContactAddedSuccessfully() {
        return actions.isElementPresent(CONTACT_ADDED_CONFIRMATION_MESSAGE);
    }

    public void returnToAddressBook() {
        actions.clickElement(RETURN_TO_ADDRESS_BOOK);
    }

    public boolean isContactVisibleOnPage(String contactName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String xpathExpression = String.format(Constants.CONTACT_VISIBILITY_XPATH, contactName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForContactVisible(String contactName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpathExpression = String.format(Constants.CONTACT_VISIBILITY_XPATH, contactName);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
    }

    public void searchForContact(String contactName) {
        actions.typeValueInField(contactName, SEARCH_FIELD_XPATH);
        WebElement searchField = driver.findElement(By.xpath(SEARCH_FIELD_XPATH));
        searchField.sendKeys(Keys.ENTER);
    }
}
