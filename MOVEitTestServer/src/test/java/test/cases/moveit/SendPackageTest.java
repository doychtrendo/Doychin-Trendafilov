package test.cases.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.moveit.LoginPage;
import pages.moveit.PackagesPage;

import java.io.File;

import static com.moveit.testframework.utils.Constants.*;

public class SendPackageTest extends BaseTest {

    @Test
    //MOV-4 [MOVEit-PackageHandling] Successfully Send Package with File Attachment
    public void testSendPackageWithAttachment() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);

        PackagesPage packagesPage = new PackagesPage(driver);
        packagesPage.clickPackagesButton();
        packagesPage.clickSendPackage();
        packagesPage.enterRecipient(PACKAGE_RECIPIENT);
        packagesPage.enterSubject(PACKAGE_SUBJECT);
        packagesPage.enterBody(PACKAGE_BODY);
        packagesPage.upload();

        File file = new File("src/test/resources/testdata/surprise.docx");
        String absolutePath = file.getAbsolutePath();

        WebElement fileInput = driver.findElement(By.className("file-selector-input"));
        fileInput.sendKeys(absolutePath);

        packagesPage.clickUpload();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue("Uploaded package is not visible.",
                packagesPage.actions.isElementPresent("//div[@title='surprise.docx'][contains(.,'surprise.docx')]"));

        packagesPage.clickClose();
        packagesPage.clickSend();

        Assert.assertTrue("Package sent confirmation message not found.",
                packagesPage.actions.isElementPresent("//div[contains(@class,'statuscontent')]"));
    }
}
