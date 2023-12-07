package test.cases.moveit;

import com.moveit.testframework.UserActions;
import com.moveit.testframework.utils.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.moveit.HomeFolderPage;
import pages.moveit.LoginPage;

import java.io.File;

public class FileUploadDownloadTest extends BaseTest {

    @Test
    public void testFileUploadDownload() {
        LoginPage loginPage = new LoginPage(driver);
        UserActions actions = new UserActions(driver);

        loginPage.navigateToPage();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);

        HomeFolderPage homeFolderPage = new HomeFolderPage(driver);

        //home folder
        homeFolderPage.clickHomeFolder();

        //file to be uploaded
        String fileName = "surprise.docx";
        File file = new File("src/test/resources/testdata/" + fileName);
        String absolutePath = file.getAbsolutePath();

        //delete file if exists
        homeFolderPage.deleteFile(fileName);

        //upload file
        homeFolderPage.clickUploadFilesButton();
        WebElement fileInput = driver.findElement(By.className("file-selector-input"));
        fileInput.sendKeys(absolutePath);

        //wait for upload
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //click upload
        homeFolderPage.clickUploadButton();

        //wait for upload
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //close
        homeFolderPage.clickCloseButton();

        //check if file uploaded
        Assert.assertTrue("File not uploaded", homeFolderPage.checkFileExists(fileName));

        //open uploaded file
        homeFolderPage.openFile(fileName);

        //check if file exist in dir //span[contains(.,'surprise.docx')]

        //click download
        homeFolderPage.clickDownloadFile();

        //wait for message to appear
        actions.waitForElementVisible("//span[@class='modal-title'][contains(.,'Validate Files')]");

        //assert message
        Assert.assertTrue("Validation message not found.",
                actions.isElementPresent("//span[@class='modal-title'][contains(.,'Validate Files')]"));
    }
}
