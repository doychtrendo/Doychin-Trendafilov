package test.cases.moveit;

import org.junit.Assert;
import org.junit.Test;
import pages.moveit.ContactsPage;
import pages.moveit.LoginPage;

import static com.moveit.testframework.utils.Constants.*;

public class AddressBookManagementTest extends BaseTest {

    @Test
    //MOV-6 [MOVEit-Contacts] Successfully Add Contact to Contacts
    public void when_NewContactAdded_expect_ContactIsVisibleInAddressBook() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage();
        loginPage.login(USER_NAME, USER_PASSWORD);

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.openContacts();
        contactsPage.clickAddContact();
        contactsPage.enterFullName(NEW_CONTACT_NAME);
        contactsPage.enterEmailAddress(NEW_CONTACT_MAIL);
        contactsPage.confirmAddContact();
        Assert.assertTrue(CONTACT_CONFIRMATION_ERROR, contactsPage.isContactAddedSuccessfully());
        contactsPage.returnToAddressBook();
        contactsPage.searchForContact(NEW_CONTACT_NAME);
        contactsPage.waitForContactVisible(NEW_CONTACT_NAME);
        Assert.assertTrue(CONTACT_NOT_FOUND_ERROR, contactsPage.isContactVisibleOnPage(NEW_CONTACT_NAME));
        loginPage.logout();
    }

}

