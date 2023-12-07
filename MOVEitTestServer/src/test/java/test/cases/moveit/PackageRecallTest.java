package test.cases.moveit;

import org.junit.Test;
import pages.moveit.LoginPage;
import pages.moveit.PackagesPage;

import static com.moveit.testframework.utils.Constants.*;

public class PackageRecallTest extends BaseTest {

    @Test
    //MOV-5 [MOVEit-PackageHandling] Successfully Recall a Sent Package
    public void when_PackageSentAndRecalled_expect_PackageRecalledSuccessfully() {
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
        packagesPage.verifyUploadedPackageVisible(FILE_NAME);
        packagesPage.clickClose();
        packagesPage.clickSend();
        packagesPage.verifyPackageSentConfirmationDisplayed();
        packagesPage.navigateToSentPackages();
        packagesPage.selectPackage(PACKAGE_BODY_SUBJECT);
        packagesPage.recallSelectedPackage();
        packagesPage.verifyRecalledPackageStatus();
    }

}
