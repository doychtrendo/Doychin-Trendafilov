package test.cases.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Test;
import pages.moveit.LoginPage;
import pages.moveit.PackagesPage;

import static com.moveit.testframework.utils.Constants.*;

public class PackageRecallTest extends BaseTest {

    @Test
    //MOV-5 [MOVEit-PackageHandling] Successfully Recall a Sent Package
    public void testSendAndRecallPackage() {
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
        packagesPage.verifyUploadedPackageVisible("surprise.docx");
        packagesPage.clickClose();
        packagesPage.clickSend();
        packagesPage.verifyPackageSentConfirmationDisplayed();
        packagesPage.navigateToSentPackages();
        packagesPage.selectPackage("test package for you");
        packagesPage.recallSelectedPackage();
        packagesPage.verifyRecalledPackageStatus();
    }
}
