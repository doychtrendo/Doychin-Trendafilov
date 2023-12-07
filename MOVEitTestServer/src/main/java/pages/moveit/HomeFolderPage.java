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
        return actions.isElementPresent("//span[contains(.,'" + fileName + "')]");
    }

    public void deleteFile(String fileName) {
        if (checkFileExists(fileName)) {
            String deleteButtonXPath = "//span[contains(.,'" + fileName + "')]/ancestor::tr//a[@title='Delete']";
            actions.clickElement(deleteButtonXPath);
            actions.clickElement("//span[contains(.,'Yes')]");
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
        String fileXPath = "//span[contains(.,'" + fileName + "')]";
        actions.clickElement(fileXPath);
    }

    public static void waitForUploadToComplete() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertFileUploaded(String fileName) {
        boolean fileExists = checkFileExists(fileName);
        Assert.assertTrue("File not uploaded: " + fileName, fileExists);
    }

    public void assertValidationMessageDisplayed() {
        boolean isValidationMessagePresent = actions.isElementPresent("//span[@class='modal-title'][contains(.,'Validate Files')]");
        Assert.assertTrue("Validation message not found.", isValidationMessagePresent);
    }

    public void waitForValidationMessage() {
        String validationMessageLocator = "//span[@class='modal-title'][contains(.,'Validate Files')]";
        actions.waitForElementVisible(validationMessageLocator);
    }

    public void uploadFile(String fileName) {
        File file = new File("src/test/resources/testdata/" + fileName);
        String absolutePath = file.getAbsolutePath();

        deleteFile(fileName);

        clickUploadFilesButton();

        WebElement fileInput = driver.findElement(By.className("file-selector-input"));
        fileInput.sendKeys(absolutePath);
    }

}
