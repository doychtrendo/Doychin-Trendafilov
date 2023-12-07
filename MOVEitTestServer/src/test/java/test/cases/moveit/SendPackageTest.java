package test.cases.moveit;

import com.moveit.testframework.utils.Constants;
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
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);

        PackagesPage packagesPage = new PackagesPage(driver);
        packagesPage.clickPackagesButton();
        packagesPage.clickSendPackage();
        packagesPage.enterRecipient(PACKAGE_RECIPIENT);
        packagesPage.enterSubject(PACKAGE_SUBJECT);
        packagesPage.enterBody(PACKAGE_BODY);
        packagesPage.upload();
        packagesPage.uploadTestFile("surprise.docx");
        packagesPage.clickUpload();
        packagesPage.waitForUploadToComplete();
        packagesPage.verifyPackageUploadedSuccessfully("surprise.docx");
        packagesPage.clickClose();
        packagesPage.clickSend();
        packagesPage.verifyPackageSentConfirmationDisplayed();
    }

    //login with the other user

    //check if file received
}
