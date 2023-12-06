package test.cases.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Test;
import pages.moveit.LoginPage;
import pages.moveit.PackagesPage;

public class SendPackageTest extends BaseTest {

    @Test
    public void testSendPackageWithAttachment() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);

        PackagesPage packagesPage = new PackagesPage(driver);
        packagesPage.clickPackagesButton();
        packagesPage.clickSendPackage();
        packagesPage.enterRecipient("recipient@example.com");
        packagesPage.enterSubject("Test Subject");
        packagesPage.enterBody("Test Body");
        packagesPage.uploadFile(" ");
        packagesPage.clickUpload();
        packagesPage.clickClose();
        packagesPage.clickSend();

    }
}
