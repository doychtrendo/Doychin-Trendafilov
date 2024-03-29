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
        String xpath = String.format(Constants.PACKAGE_TITLE_XPATH, fileName, fileName);
        boolean isUploaded = actions.isElementPresent(xpath);
        Assert.assertTrue(String.format(Constants.UPLOAD_NOT_VISIBLE_MSG, fileName), isUploaded);
    }

    public void verifyPackageSentConfirmationDisplayed() {
        boolean isConfirmationDisplayed = actions.isElementPresent(Constants.PACKAGE_SENT_CONFIRMATION_XPATH);
        Assert.assertTrue(Constants.PACKAGE_SENT_CONFIRMATION_NOT_FOUND_MSG, isConfirmationDisplayed);
    }

    public void uploadTestFile(String fileName) {
        File file = new File(TESTDATA_PATH + fileName);
        String absolutePath = file.getAbsolutePath();

        WebElement fileInput = driver.findElement(By.className(Constants.FILE_SELECTOR_INPUT_CLASS));
        fileInput.sendKeys(absolutePath);
    }

    public void waitForUploadToComplete() {
        try {
            Thread.sleep(UPLOAD_COMPLETION_WAIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyUploadedPackageVisible(String fileName) {
        String xpath = String.format(Constants.PACKAGE_TITLE_XPATH, fileName, fileName);
        Assert.assertTrue(String.format(Constants.UPLOAD_NOT_VISIBLE_MSG, fileName),
                actions.isElementPresent(xpath));
    }

    public void verifyRecalledPackageStatus() {
        Assert.assertTrue(Constants.RECALL_STATUS_NOT_FOUND_MSG,
                actions.isElementPresent(Constants.RECALL_STATUS_XPATH));
    }

    public void navigateToSentPackages() {
        actions.clickElement(Constants.SENT_LINK_XPATH);
    }

    public void selectPackage(String packageName) {
        String xpath = String.format(Constants.PACKAGE_NAME_LINK_XPATH, packageName);
        actions.clickElement(xpath);
    }

    public void recallSelectedPackage() {
        actions.clickElement(Constants.RECALL_BUTTON_XPATH);
        actions.waitForElementVisible(Constants.CONFIRM_RECALL_XPATH);
        actions.clickElement(Constants.CONFIRM_YES_XPATH);
    }

    public void clickPackageWithTitle(String title) {
        actions.clickElement(String.format(PACKAGE_TITLE, title));
    }

    public void assertPackageSubject(String expectedSubject) {
        Assert.assertTrue(SUBJECT_NOT_EXPECTED_MSG,
                actions.isElementPresent(String.format(PACKAGE_SUBJECT_XPATH, expectedSubject)));
    }

    public void assertPackageNameAndClick(String fileName) {
        WebElement fileElement = driver.findElement(By.xpath(String.format(PACKAGE_NAME_XPATH, fileName)));
        Assert.assertTrue(NAME_NOT_EXPECTED_MSG, fileElement.isDisplayed());
        fileElement.click();
    }

    public void assertPackageSender(String expectedSender) {
        Assert.assertTrue(SENDER_NOT_EXPECTED_MSG,
                actions.isElementPresent(String.format(PACKAGE_SENDER_XPATH, expectedSender)));
    }

    public void clickReturnToParentPackage() {
        actions.clickElement(RETURN_TO_PARENT_PACKAGE_XPATH);
    }

    public void clickDelete() {
        actions.clickElement(DELETE_XPATH);
    }

    public void assertDeletionConfirmation(String expectedMessage) {
        Assert.assertTrue(DELETION_MSG_NOT_SHOWN,
                actions.isElementPresent(String.format(DELETION_CONFIRMATION_XPATH, expectedMessage)));
    }

}
