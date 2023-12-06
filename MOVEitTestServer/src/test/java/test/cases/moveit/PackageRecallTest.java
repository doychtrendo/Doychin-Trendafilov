package test.cases.moveit;

import com.moveit.testframework.UserActions;
import com.moveit.testframework.utils.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.moveit.LoginPage;
import pages.moveit.PackagesPage;

import java.io.File;

import static com.moveit.testframework.utils.Constants.*;

public class PackageRecallTest extends BaseTest {

    @Test
    public void testSendAndRecallPackage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);

        PackagesPage packagesPage = new PackagesPage(driver);
        UserActions actions = new UserActions(driver); // Create an instance of UserActions

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
                actions.isElementPresent("//div[@title='surprise.docx'][contains(.,'surprise.docx')]"));

        packagesPage.clickClose();
        packagesPage.clickSend();

        //recall
        actions.clickElement("//a[contains(.,'Sent')]");
        actions.clickElement("//a[contains(text(), 'test package for you')]");
        actions.clickElement("//span[contains(.,'Recall')]");

        //wait for conf
        actions.waitForElementVisible("//span[contains(.,'Confirm Recall of Package')]");
        actions.clickElement("//span[contains(.,'Yes')]");

        //assert message
        Assert.assertTrue("Recall status message not found.",
                actions.isElementPresent("//div[@class='statuscontent'][contains(.,'Recalled package OK.')]"));
    }
}
