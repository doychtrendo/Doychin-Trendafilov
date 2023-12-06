package pages.moveit;

import com.moveit.testframework.utils.Constants;
import org.openqa.selenium.WebDriver;

import static com.moveit.testframework.utils.Constants.*;

public class PackagesPage extends BasePage {

    public PackagesPage(WebDriver driver) {
        super(driver, Constants.HOME_PAGE);
    }

    public void clickPackagesButton() {
        actions.clickElement(PACKAGES_BUTTON_XPATH);
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
