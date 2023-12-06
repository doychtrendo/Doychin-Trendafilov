package test.cases.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Test;
import pages.moveit.LoginPage;
import pages.moveit.PackagesPage;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.moveit.testframework.utils.Constants.*;


public class SendPackageTest extends BaseTest {

    @Test
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
        packagesPage.browse();

        try {
            Robot robot = new Robot();
            robot.delay(1000);

            String fileName = "surprise.docx";
            for (char c : fileName.toCharArray()) {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                if (Character.isUpperCase(c)) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                if (Character.isUpperCase(c)) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
            }

            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }

        packagesPage.clickUpload();
        packagesPage.clickClose();
        packagesPage.clickSend();

    }
}
