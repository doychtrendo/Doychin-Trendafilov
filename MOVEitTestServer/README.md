**MOVEit Automation Testing**

**Overview**

This project encompasses automated tests for MOVEit Transfer using Selenium WebDriver, with a focus on key functionalities like login authentication, handling invalid login attempts, package management, file operations, and address book management. The tests are crafted in Java, employing the Page Object Model (POM) for maintainability and scalability.

**Installation and Setup**

**Prerequisites:**

-   Java Development Kit (JDK) 11 or higher.
-   Maven for managing project dependencies.
-   Compatible WebDrivers for browser-based automation.

**Setting Up:**

1.  Clone or download the source code from the [GitHub repository](https://github.com/doychtrendo/Doychin-Trendafilov).
2.  Open the project in an IDE (e.g., IntelliJ IDEA, Eclipse).
3.  Ensure Maven dependencies are correctly resolved.
4.  Update Constants.java with MOVEit Transfer credentials and URLs (pre-configured for the purpose of this assignment).

**Running Tests**

Execute tests from your IDE by right-clicking on a test or test suite and selecting 'Run'.

**Test Cases**

The project includes:

-   **LoginTest:** Verifies successful/failed login scenarios and logout process.
-   **SendPackageTest:** Tests package sending with attachments, ensuring proper delivery and deletion by recipients.
-   **FileUploadDownloadTest:** Validates file upload and download functionalities.
-   **PackageRecallTest:** Assesses package sending and recall capabilities.
-   **AddressBookManagementTest:** Tests adding and verifying new contacts in the address book.

**Documentation**

-   **Test Cases, Bugs, and Suggestions:** Compiled in 'MOVEit Test Cases, Bugs, and Suggestions.xlsx'. Accessible via [JIRA link](https://doychintrendafilov.atlassian.net/jira/software/c/projects/MOV/boards/1?atlOrigin=eyJpIjoiMjBlOWFkMzJlMWNlNDhiYTg5ZTcyMWJmMjZjODc1YzAiLCJwIjoiaiJ9).
-   **Exploratory Testing:** Documented insights from exploratory testing sessions.
-   **Project Repository:** Source code available on [GitHub](https://github.com/doychtrendo/Doychin-Trendafilov).

**Strategy**

**December 2nd - 3rd:**

-   Explore MOVEit Transfer documentation and videos.
-   Set up a JIRA project for managing test cases and tracking bugs.

**December 4th:**

-   Implement Jira Xray for enhanced test management.
-   Create an exploratory testing strategy.
-   Establish a manual test case template.
-   Identify 10 key test cases, selecting at least 5 for automation.

**December 5th:**

-   Document manual test cases in JIRA and a separate file.
-   Perform exploratory testing to uncover and record bugs.

**December 6th:**

-   Develop an automation framework tailored to the identified test cases.
-   Begin Selenium-based test case automation.

**December 7th:**

-   Finalize and compile the README documentation.

**Test Execution Status**

All automated tests have been successfully executed, confirming the effectiveness and accuracy of the testing framework and the functionalities of MOVEit Transfer tested.
