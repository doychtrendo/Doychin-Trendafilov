package pages.moveit;

import com.moveit.testframework.utils.Constants;
import org.openqa.selenium.WebDriver;

public class PackagesPage extends BasePage {

    private static final String PACKAGES_BUTTON = "//span[contains(.,'Packages')]";
    private static final String SEND_PACKAGE_BUTTON_XPATH = "//span[contains(.,'Send Package')]";
    private static final String RECIPIENT_FIELD_XPATH = "//input[contains(@name,'opt01')]";
    private static final String SUBJECT_FIELD_XPATH = "//input[contains(@name,'arg01')]";
    private static final String BODY_FIELD_XPATH = "//*[@id=\"arg04\"]";
    private static final String UPLOAD_FILE_BUTTON_XPATH = "//a[contains(.,'Upload Files')]";
    private static final String BROWSE_BUTTON_XPATH = "//span[@tabindex='0'][contains(.,'Browse...')]";
    private static final String UPLOAD_BUTTON_XPATH = "//button[@data-testid='modal-footer-button-primary'][contains(.,'Upload')]";
    private static final String CLOSE_BUTTON_XPATH = "//button[@data-testid='modal-footer-button-primary'][contains(.,'Close')]";
    private static final String SEND_BUTTON_XPATH = "//span[contains(.,'Send')]";

    public PackagesPage(WebDriver driver) {
        super(driver, Constants.HOME_PAGE);
    }

    public void clickPackagesButton() {
        actions.clickElement(PACKAGES_BUTTON);
    }

    public void clickSendPackage() {
        actions.clickElement(SEND_PACKAGE_BUTTON_XPATH);
    }

    public void enterRecipient(String recipient) {
        actions.typeValueInField(recipient, RECIPIENT_FIELD_XPATH);
    }

    public void enterSubject(String subject) {
        actions.typeValueInField(subject, SUBJECT_FIELD_XPATH);
    }

    public void enterBody(String body) {
        actions.typeValueInField(body, BODY_FIELD_XPATH);
    }

    public void uploadFile(String filePath) {
        actions.clickElement(UPLOAD_FILE_BUTTON_XPATH);
    }

    public void clickUpload() {
        actions.clickElement(UPLOAD_BUTTON_XPATH);
    }

    public void clickClose() {
        actions.clickElement(CLOSE_BUTTON_XPATH);
    }

    public void clickSend() {
        actions.clickElement(SEND_BUTTON_XPATH);
    }

}
