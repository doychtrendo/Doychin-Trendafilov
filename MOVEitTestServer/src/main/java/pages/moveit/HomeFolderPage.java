package pages.moveit;

import com.moveit.testframework.utils.Constants;
import org.openqa.selenium.WebDriver;

public class HomeFolderPage extends BasePage {

    private static final String HOME_FOLDER_BUTTON = "//span[contains(.,'Home Folder')]";
    private static final String UPLOAD_FILES_BUTTON = "//span[contains(.,'Upload Files')]";
    private static final String UPLOAD_BUTTON = "//button[@data-testid='modal-footer-button-primary'][contains(.,'Upload')]";
    private static final String CLOSE_BUTTON = "//button[@data-testid='modal-footer-button-primary'][contains(.,'Close')]"; //button[@data-testid='modal-footer-button-primary'][contains(.,'Close')]
    private static final String DOWNLOAD_BUTTON = "//span[contains(.,'Download')]";

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

}
