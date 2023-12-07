package test.cases.moveit;

import org.junit.Test;
import pages.moveit.LoginPage;
import pages.moveit.PackagesPage;

import static com.moveit.testframework.utils.Constants.*;

public class SendPackageTest extends BaseTest {

    @Test
    //MOV-4 [MOVEit-PackageHandling] Successfully Send Package with File Attachment
    public void testSendPackageWithAttachment() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(USER_NAME, USER_PASSWORD);

        PackagesPage packagesPage = new PackagesPage(driver);
        packagesPage.clickPackagesButton();
        packagesPage.clickSendPackage();
        packagesPage.enterRecipient(PACKAGE_RECIPIENT);
        packagesPage.enterSubject(PACKAGE_SUBJECT);
        packagesPage.enterBody(PACKAGE_BODY);
        packagesPage.upload();
        packagesPage.uploadTestFile(FILE_NAME);
        packagesPage.clickUpload();
        packagesPage.waitForUploadToComplete();
        packagesPage.verifyPackageUploadedSuccessfully(FILE_NAME);
        packagesPage.clickClose();
        packagesPage.clickSend();
        packagesPage.verifyPackageSentConfirmationDisplayed();
    }

    //login with the other user

    //check if file received
}
