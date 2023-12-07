package com.moveit.testframework.utils;

public class Constants {

    // URL and Path Constants
    public static final String HOME_PAGE = "MOVEit.homePage";
    public static final String LOGIN_PAGE = "MOVEit.loginPage";
    public static final String TESTDATA_PATH = "src/test/resources/testdata/";

    // User Credentials Constants
    public static final String USER_NAME = "MOVEit.username";
    public static final String USER_PASSWORD = "MOVEit.password";
    public static final String INVALID_USER_NAME = "MOVEit.invalidUsername";
    public static final String INVALID_USER_PASSWORD = "MOVEit.invalidPassword";
    public static final String RECIPIENT_USER_NAME = "MOVEit.recipientUsername";
    public static final String RECIPIENT_PASSWORD = "MOVEit.recipientPassword";

    // Login Page Constants
    public static final String LOGIN_USERNAME_FIELD_PATH = "loginPage.usernameField";
    public static final String LOGIN_PASSWORD_FIELD_PATH = "loginPage.passwordField";
    public static final String LOGIN_BUTTON_PATH = "loginPage.loginButton";
    public static final String LOGIN_ERROR_MESSAGE = "loginPage.errorMessage";
    public static final String LOGOUT_BUTTON = "homePage.logoutButton";

    // Package Management Constants
    public static final String PACKAGES_BUTTON_XPATH = "packagesPage.packagesButton";
    public static final String SEND_PACKAGE_BUTTON_XPATH = "packagesPage.sendPackageButton";
    public static final String RECIPIENT_FIELD_XPATH = "packagesPage.recipientField";
    public static final String SUBJECT_FIELD_XPATH = "packagesPage.subjectField";
    public static final String BODY_FIELD_XPATH = "packagesPage.bodyField";
    public static final String UPLOAD_FILE_BUTTON_XPATH = "packagesPage.uploadFileButton";
    public static final String UPLOAD_BUTTON_XPATH = "packagesPage.uploadButton";
    public static final String CLOSE_BUTTON_XPATH = "packagesPage.closeButton";
    public static final String SEND_BUTTON_XPATH = "packagesPage.sendButton";
    public static final String PACKAGE_RECIPIENT = "doychj@gmail.com";
    public static final String PACKAGE_SUBJECT = "test package for you";
    public static final String PACKAGE_BODY = "nice package!";
    public static final String EXPECTED_SENDER = "interview.doychin.trendafilov (interview.doychin.trendafilov)";

    // Contact Management Constants
    public static final String CONTACTS_BUTTON = "contactsPage.contactsButton";
    public static final String ADD_CONTACT_BUTTON = "contactsPage.addContactButton";
    public static final String CONTACT_NAME = "contactsPage.contactName";
    public static final String CONTACT_EMAIL = "contactsPage.contactEmail";
    public static final String ADD_CONTACT_CONFIRMATION_BUTTON = "contactsPage.confirmAddContact";
    public static final String CONTACT_ADDED_CONFIRMATION_MESSAGE = "contactsPage.confirmMessage";
    public static final String RETURN_TO_ADDRESS_BOOK = "contactsPage.returnToAddressBook";
    public static final String NEW_CONTACT_NAME = "John Doe";
    public static final String NEW_CONTACT_MAIL = "john.doe@example.com";
    public static final String CONTACT_CONFIRMATION_ERROR = "Contact addition confirmation message not found";
    public static final String CONTACT_NOT_FOUND_ERROR = "John Doe is not visible on page";

    // Home Folder Constants
    public static final String HOME_FOLDER_BUTTON = "homeFolder.homeFolderButton";
    public static final String UPLOAD_FILES_BUTTON = "homeFolder.uploadFilesButton";
    public static final String UPLOAD_BUTTON = "homeFolder.uploadButton";
    public static final String CLOSE_BUTTON = "homeFolder.closeButton";
    public static final String DOWNLOAD_BUTTON = "homeFolder.downloadButton";
    public static final String FILE_NOT_UPLOADED_MESSAGE = "File not uploaded: %s";
    public static final String VALIDATION_MESSAGE_NOT_FOUND = "Validation message not found.";
    public static final String VALIDATION_MESSAGE = "homeFolder.validationMessage";

    // Dynamic XPath Constants
    public static final String PACKAGE_TITLE_XPATH = "//div[@title='%s'][contains(.,'%s')]";
    public static final String PACKAGE_SENT_CONFIRMATION_XPATH = "//div[contains(@class,'statuscontent')]";
    public static final String FILE_SELECTOR_INPUT_CLASS = "file-selector-input";
    public static final String RECALL_STATUS_XPATH = "//div[@class='statuscontent'][contains(.,'Recalled package OK.')]";
    public static final String SENT_LINK_XPATH = "//a[contains(.,'Sent')]";
    public static final String PACKAGE_NAME_LINK_XPATH = "//a[contains(text(), '%s')]";
    public static final String RECALL_BUTTON_XPATH = "//span[contains(.,'Recall')]";
    public static final String CONFIRM_RECALL_XPATH = "//span[contains(.,'Confirm Recall of Package')]";
    public static final String CONFIRM_YES_XPATH = "//span[contains(.,'Yes')]";
    public static final String FILE_SPAN = "//span[contains(.,'%s')]";
    public static final String DELETE_BUTTON = "//span[contains(.,'Delete')]";
    public static final String DELETE_YES_BUTTON = "//span[contains(.,'Yes')]";
    public static final String SEARCH_FIELD_XPATH = "//input[contains(@placeholder,'Search')]";
    public static final String CONTACT_VISIBILITY_XPATH = "//td[@class='textsmall'][contains(.,'%s')]";

    // Message Constants
    public static final String UPLOAD_NOT_VISIBLE_MSG = "Uploaded package %s is not visible.";
    public static final String PACKAGE_SENT_CONFIRMATION_NOT_FOUND_MSG = "Package sent confirmation message not found.";
    public static final String RECALL_STATUS_NOT_FOUND_MSG = "Recall status message not found.";
    public static final String URL_ERROR_MESSAGE = "Landed URL is not as expected. Actual URL: ";
    public static final String EXPECTED_URL_MESSAGE = "'. Expected URL: '";
    public static final String PACKAGE_DELETED_MESSAGE = "Trashed package OK.";

    // Miscellaneous Constants
    public static final String FILE_NAME = "surprise.docx";
    public static final String PACKAGE_BODY_SUBJECT = "test package for you";
    public static final long UPLOAD_COMPLETION_WAIT_TIME = 10000;
    public static final String FILE_SELECTOR = "file-selector-input";

    // XPaths
    public static final String PACKAGE_TITLE = "//b[contains(.,'%s')]";
    public static final String PACKAGE_SUBJECT_XPATH = "//h3[contains(text(),'%s')]";
    public static final String PACKAGE_NAME_XPATH = "//a[contains(text(),'%s')]";
    public static final String PACKAGE_SENDER_XPATH = "//span[contains(text(),'%s')]";
    public static final String RETURN_TO_PARENT_PACKAGE_XPATH = "//span[contains(.,'Return to Parent Package')]";
    public static final String DELETE_XPATH = "//span[contains(.,'Delete')]";
    public static final String DELETION_CONFIRMATION_XPATH = "//div[@class='statuscontent'][contains(text(),'%s')]";

    // Messages
    public static final String SUBJECT_NOT_EXPECTED_MSG = "Package subject not as expected";
    public static final String NAME_NOT_EXPECTED_MSG = "Package name not as expected";
    public static final String SENDER_NOT_EXPECTED_MSG = "Package sender not as expected";
    public static final String DELETION_MSG_NOT_SHOWN = "Deletion confirmation message not shown";

}
