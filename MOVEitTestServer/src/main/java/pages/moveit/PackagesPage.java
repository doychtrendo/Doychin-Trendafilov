package pages.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

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

    public void upload() {
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

    public void verifyPackageUploadedSuccessfully(String fileName) {
        boolean isUploaded = actions.isElementPresent("//div[@title='" + fileName + "'][contains(.,'" + fileName + "')]");
        Assert.assertTrue("Uploaded package " + fileName + " is not visible.", isUploaded);
    }

    public void verifyPackageSentConfirmationDisplayed() {
        boolean isConfirmationDisplayed = actions.isElementPresent("//div[contains(@class,'statuscontent')]");
        Assert.assertTrue("Package sent confirmation message not found.", isConfirmationDisplayed);
    }

    public void uploadTestFile(String fileName) {
        File file = new File("src/test/resources/testdata/" + fileName);
        String absolutePath = file.getAbsolutePath();

        WebElement fileInput = driver.findElement(By.className("file-selector-input"));
        fileInput.sendKeys(absolutePath);
    }

    public void waitForUploadToComplete() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
