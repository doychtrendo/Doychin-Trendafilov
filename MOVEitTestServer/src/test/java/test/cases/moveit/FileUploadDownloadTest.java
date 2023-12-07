package test.cases.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Test;
import pages.moveit.HomeFolderPage;
import pages.moveit.LoginPage;

public class FileUploadDownloadTest extends BaseTest {

    @Test
    public void testFileUploadDownload() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);

        HomeFolderPage homeFolderPage = new HomeFolderPage(driver);
        homeFolderPage.clickHomeFolder();

        String fileName = "surprise.docx";
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
