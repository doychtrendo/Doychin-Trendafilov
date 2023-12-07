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
        loginPage.logout();

        loginPage.navigateToPage();
        loginPage.login(RECIPIENT_USER_NAME, RECIPIENT_PASSWORD);
        packagesPage.clickPackageWithTitle(PACKAGE_SUBJECT);
        packagesPage.assertPackageSubject(PACKAGE_SUBJECT);
        packagesPage.assertPackageNameAndClick(FILE_NAME);
        packagesPage.assertPackageSender(EXPECTED_SENDER);
        packagesPage.clickReturnToParentPackage();
        packagesPage.clickDelete();
        packagesPage.assertDeletionConfirmation(PACKAGE_DELETED_MESSAGE);
        loginPage.logout();
    }

}
