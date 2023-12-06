package com.moveit.testframework.utils;

public class Constants {

    // URLs
    public static final String HOME_PAGE = "MOVEit.homePage";
    public static final String LOGIN_PAGE = "MOVEit.loginPage";

    // XPath for LoginPage
    public static final String LOGIN_USERNAME_FIELD_PATH = "loginPage.usernameField";
    public static final String LOGIN_PASSWORD_FIELD_PATH = "loginPage.passwordField";
    public static final String LOGIN_BUTTON_PATH = "loginPage.loginButton";
    public static final String LOGIN_SECURE_MESSAGE = "loginPage.secureMessage";
    public static final String LOGIN_ERROR_MESSAGE = "loginPage.errorMessage";
    public static final String LOGOUT_BUTTON = "homePage.logoutButton";

    // UserData
    public static final String USER_NAME = "MOVEit.username";
    public static final String USER_PASSWORD = "MOVEit.password";
    public static final String INVALID_USER_NAME = "MOVEit.invalidUsername";
    public static final String INVALID_USER_PASSWORD = "MOVEit.invalidPassword";
    public static final String NEW_CONTACT_NAME = "John Doe";
    public static final String NEW_CONTACT_MAIL = "john.doe@example.com";
    public static final String CONTACT_CONFIRMATION_ERROR = "Contact addition confirmation message not found";
    public static final String CONTACT_NOT_FOUND_ERROR = "John Doe is not visible on page";

    // XPath for PackagesPage
    public static final String PACKAGES_BUTTON_XPATH = "packagesPage.packagesButton";
    public static final String SEND_PACKAGE_BUTTON_XPATH = "packagesPage.sendPackageButton";
    public static final String RECIPIENT_FIELD_XPATH = "packagesPage.recipientField";
    public static final String SUBJECT_FIELD_XPATH = "packagesPage.subjectField";
    public static final String BODY_FIELD_XPATH = "packagesPage.bodyField";
    public static final String UPLOAD_FILE_BUTTON_XPATH = "packagesPage.uploadFileButton";
    public static final String BROWSE_BUTTON_XPATH = "packagesPage.browseButton";
    public static final String UPLOAD_BUTTON_XPATH = "packagesPage.uploadButton";
    public static final String CLOSE_BUTTON_XPATH = "packagesPage.closeButton";
    public static final String SEND_BUTTON_XPATH = "packagesPage.sendButton";

    public static final String PACKAGE_RECIPIENT = "doychj@gmail.com";
    public static final String PACKAGE_SUBJECT = "test package for you";
    public static final String PACKAGE_BODY = "nice package!";

    public static final String CONTACTS_BUTTON = "contactsPage.contactsButton";
    public static final String ADD_CONTACT_BUTTON = "contactsPage.addContactButton";
    public static final String CONTACT_NAME = "contactsPage.contactName";
    public static final String CONTACT_EMAIL = "contactsPage.contactEmail";
    public static final String ADD_CONTACT_CONFIRMATION_BUTTON = "contactsPage.confirmAddContact";
    public static final String CONTACT_ADDED_CONFIRMATION_MESSAGE = "contactsPage.confirmMessage";
    public static final String ADDRESS_BOOK_SEARCH = "contactsPage.addressSearch";
    public static final String RETURN_TO_ADDRESS_BOOK = "contactsPage.returnToAddressBook";

}
