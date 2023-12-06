package pages.moveit;

import com.moveit.testframework.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPage extends BasePage {

    private static final String CONTACTS_BUTTON_XPATH = "//span[contains(.,'Contacts')]";
    private static final String ADD_CONTACT_BUTTON_XPATH = "//span[contains(.,'Add contact...')]";
    private static final String FULL_NAME_FIELD_XPATH = "//input[contains(@name,'arg02')]";
    private static final String EMAIL_ADDRESS_FIELD_XPATH = "//input[contains(@name,'arg01')]";
    private static final String CONFIRM_ADD_CONTACT_BUTTON_XPATH = "//span[contains(.,'Add contact')]";
    private static final String CONFIRMATION_MESSAGE_XPATH = "//div[@class='statuscontent'][contains(.,'Added address book contact OK.Click here to return to the address book.')]";
    private static final String RETURN_TO_ADDRESS_BOOK_XPATH = "//span[contains(.,'Click here to return to the address book.')]";
    private static final String SEARCH_FIELD_XPATH = "//input[contains(@placeholder,'Search')]";

    public ContactsPage(WebDriver driver) {
        super(driver, Constants.HOME_PAGE);
    }

    public void openContacts() {
        actions.clickElement(CONTACTS_BUTTON_XPATH);
    }

    public void clickAddContact() {
        actions.clickElement(ADD_CONTACT_BUTTON_XPATH);
    }

    public void enterFullName(String fullName) {
        actions.typeValueInField(fullName, FULL_NAME_FIELD_XPATH);
    }

    public void enterEmailAddress(String emailAddress) {
        actions.typeValueInField(emailAddress, EMAIL_ADDRESS_FIELD_XPATH);
    }

    public void confirmAddContact() {
        actions.clickElement(CONFIRM_ADD_CONTACT_BUTTON_XPATH);
    }

    public boolean isContactAddedSuccessfully() {
        return actions.isElementPresent(CONFIRMATION_MESSAGE_XPATH);
    }

    public void returnToAddressBook() {
        actions.clickElement(RETURN_TO_ADDRESS_BOOK_XPATH);
    }

    public boolean isContactVisibleOnPage(String contactName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String xpathExpression = "//td[@class='textsmall'][contains(.,'" + contactName + "')]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForContactVisible(String contactName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpathExpression = "//td[@class='textsmall'][contains(.,'" + contactName + "')]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
    }

    public void searchForContact(String contactName) {
        actions.typeValueInField(contactName, SEARCH_FIELD_XPATH);
        WebElement searchField = driver.findElement(By.xpath(SEARCH_FIELD_XPATH));
        searchField.sendKeys(Keys.ENTER);
    }
}
