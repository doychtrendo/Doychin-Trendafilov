package test.cases.moveit;

import com.moveit.testframework.utils.Constants;
import org.junit.Assert;
import org.junit.Test;
import pages.moveit.ContactsPage;
import pages.moveit.LoginPage;

public class AddressBookManagementTest extends BaseTest {

    @Test
    public void testAddNewContact() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(Constants.USER_NAME, Constants.USER_PASSWORD);

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.openContacts();
        contactsPage.clickAddContact();
        contactsPage.enterFullName("John Doe");
        contactsPage.enterEmailAddress("john.doe@example.com");
        contactsPage.confirmAddContact();
        Assert.assertTrue("Contact addition confirmation message not found", contactsPage.isContactAddedSuccessfully());

        contactsPage.returnToAddressBook();
        contactsPage.searchForContact("John Doe");
        contactsPage.waitForContactVisible("John Doe");
        Assert.assertTrue("John Doe is not visible on page", contactsPage.isContactVisibleOnPage("John Doe"));

    }

}

