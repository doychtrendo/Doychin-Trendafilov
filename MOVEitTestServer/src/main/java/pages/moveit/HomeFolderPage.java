package pages.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.moveit.testframework.utils.Constants.*;

public class HomeFolderPage extends BasePage {

    public HomeFolderPage(WebDriver driver) {
        super(driver, Constants.HOME_PAGE);
    }

    public void clickHomeFolder() {
        actions.clickElement(HOME_FOLDER_BUTTON);
    }

    public boolean checkFileExists(String fileName) {
        return actions.isElementPresent(String.format(Constants.FILE_SPAN, fileName));
    }

    public void deleteFile(String fileName) {
        if (checkFileExists(fileName)) {
            actions.clickElement(String.format(Constants.FILE_SPAN, fileName));
            actions.clickElement(String.format(Constants.DELETE_BUTTON, fileName));
            actions.clickElement(Constants.DELETE_YES_BUTTON);
        }
    }

    public void clickUploadButton() {
        actions.clickElement(UPLOAD_BUTTON);
    }

    public void clickUploadFilesButton() {
        actions.clickElement(UPLOAD_FILES_BUTTON);
    }

    public void clickCloseButton() {
        actions.clickElement(CLOSE_BUTTON);
    }

    public void clickDownloadFile() {
        actions.clickElement(DOWNLOAD_BUTTON);
    }

    public void openFile(String fileName) {
        actions.clickElement(String.format(FILE_SPAN, fileName));
    }

    public static void waitForUploadToComplete() {
        try {
            Thread.sleep(UPLOAD_COMPLETION_WAIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertFileUploaded(String fileName) {
        Assert.assertTrue(String.format(FILE_NOT_UPLOADED_MESSAGE, fileName), checkFileExists(fileName));
    }

    public void assertValidationMessageDisplayed() {
        Assert.assertTrue(VALIDATION_MESSAGE_NOT_FOUND, actions.isElementPresent(VALIDATION_MESSAGE));
    }

    public void waitForValidationMessage() {
        actions.waitForElementVisible(VALIDATION_MESSAGE);
    }

    public void uploadFile(String fileName) {
        File file = new File(TESTDATA_PATH + fileName);
        String absolutePath = file.getAbsolutePath();

        deleteFile(fileName);

        clickUploadFilesButton();

        WebElement fileInput = driver.findElement(By.className(FILE_SELECTOR));
        fileInput.sendKeys(absolutePath);
    }
}
