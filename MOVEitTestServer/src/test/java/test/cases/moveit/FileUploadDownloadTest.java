package test.cases.moveit;

import org.junit.Test;
import pages.moveit.HomeFolderPage;
import pages.moveit.LoginPage;

import static com.moveit.testframework.utils.Constants.*;

public class FileUploadDownloadTest extends BaseTest {

    @Test
    //MOV-7 [MOVEit-FileManagement] Successful File Upload and Download
    public void testFileUploadDownload() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(USER_NAME, USER_PASSWORD);

        HomeFolderPage homeFolderPage = new HomeFolderPage(driver);
        homeFolderPage.clickHomeFolder();
        String fileName = FILE_NAME;
        homeFolderPage.checkFileExists(fileName);
        homeFolderPage.deleteFile(fileName);
        homeFolderPage.uploadFile(fileName);
        HomeFolderPage.waitForUploadToComplete();
        homeFolderPage.clickUploadButton();
        HomeFolderPage.waitForUploadToComplete();
        homeFolderPage.clickCloseButton();
        homeFolderPage.assertFileUploaded(fileName);
        homeFolderPage.openFile(fileName);
        homeFolderPage.clickDownloadFile();
        homeFolderPage.waitForValidationMessage();
        homeFolderPage.assertValidationMessageDisplayed();
    }

}
