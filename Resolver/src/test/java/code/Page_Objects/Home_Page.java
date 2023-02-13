package code.Page_Objects;

import code.AAA_Utils.Browser_Utils;
import code.Base_Page.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;
import static code.AAA_Utils.Driver.getDriver;

public class Home_Page extends BasePage {

    private static final Logger logger = Logger.getLogger(Home_Page.class);

    /** TEST 1 **/
    @FindBy(id = "inputEmail" )
    private WebElement emailBox;
    @FindBy(id = "inputPassword")
    private WebElement passwordBox;
    @FindBy(xpath = "//button[.='Sign in']")
    private WebElement signInButton;

        /** TEST 2 **/
        @FindBy(className = "list-group")
        private WebElement listGroup;

            /** TEST 3 **/
            @FindBy(id = "dropdownMenuButton")
            private WebElement dropDownVerify;

                /** TEST 4 **/
                @FindBy(xpath = "//div[@id='test-4-div']/button[1]")
                private WebElement enabledButton;
                @FindBy(xpath = "//div[@id='test-4-div']/button[2]")
                private WebElement disabledButton;

                    /** TEST 5 **/
                    @FindBy(xpath = "//button[@id='test5-button']")
                    private WebElement waitForButton;
                    @FindBy(xpath = "//div[@id='test5-alert']")
                    private WebElement waitForMessage;

                        /** TEST 6 **/
                        @FindBy(css = "table tbody tr")
                        private List<WebElement> rows;
                        @FindBy(css = "table thead th")
                        private List<WebElement> cols;
                        @FindBy(xpath = "//h1[.='Test 6']")
                        private WebElement headerOfTheTable;

        /** TEST 1 **/
        public WebElement getEmailBox() { return emailBox; }
        public WebElement getPasswordBox() { return passwordBox; }
        public WebElement getSignInButton() { return signInButton; }

            /** TEST 2 **/
            public WebElement getListGroup() { return listGroup; }

                /** TEST 3 **/
                public WebElement getDropDownVerify() { return dropDownVerify; }

                    /** TEST 4 **/
                    public WebElement getEnabledButton() { return enabledButton; }
                    public WebElement getDisabledButton() { return disabledButton; }

                        /** TEST 5 **/
                        public WebElement getWaitForButton() { return waitForButton; }
                        public WebElement getWaitForMessage() { return waitForMessage; }

                            /** TEST 6 **/
                            public List<WebElement> getRows() { return rows; }
                            public List<WebElement> getCols() { return cols; }
                            public WebElement getHeaderOfTheTable() { return headerOfTheTable; }



    /**
                        ******************************     TEST 01     ********************************

     * This code checks if an element on a website, called "emailBox," is visible. If it's visible, the test passes.
     * If not, the test fails and shows an error message. It also waits for 2 seconds before checking.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void  setVerifyEmailBox(){
        Browser_Utils.staticWait(2);
            Assert.assertTrue(getEmailBox().isDisplayed(), "Email Box is not displayed");
            logger.info("Email box successfully verified");
    }

    /**

     * This code checks if a website element called "passwordBox" is visible on the page. If it's visible, the test passes.
     * If not, the test fails and displays an error message saying "Password Box is not displayed."

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void setVerifyPasswordBox() {
        Assert.assertTrue(getPasswordBox().isDisplayed(), "Password Box is not displayed");
        logger.info("Password box successfully verified");

    }

    /**

     * This code checks the visibility and clickability of a website element called "signInButton," which is likely a button.
     * If the button is visible and can be clicked, the test passes. If either the visibility or clickability fails, the test
     * fails and displays an error message saying either "Button is not displayed" or "Button is not clickable."

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void setVerifySignIn(){
        Assert.assertTrue(getSignInButton().isDisplayed(), "Button is not displayed");
        logger.info("Sign in button is displayed at the moment");
            Assert.assertTrue(getSignInButton().isEnabled(), "Button is not clickable");
            logger.info("Sign in button is clickable at the moment");

    }

    public void setSignInWithCorrectCredentials(String email, String password){
        getEmailBox().click();
        Browser_Utils.staticWait(1);
            getEmailBox().sendKeys(email);
            getPasswordBox().click();
                Browser_Utils.staticWait(1);
                    getPasswordBox().sendKeys(password);
                    getSignInButton().click();
    }



    /**
                     ******************************     TEST 02     ********************************


     * this code checks the values of a list on a web page. It first verifies the number of items in the list and then
     * checks the text and badge value of a specific item. If all checks pass, the code considers the list to be correct.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void setListGroup(String listItem, String badgeValue, int expectedListSize, int indexOfListElement) {
        List<WebElement> listItems = getListGroup().findElements(By.cssSelector("li.list-group-item"));
        // Assert that there are three values in the listgroup
        Assert.assertEquals(listItems.size(), expectedListSize);
            logger.info("All the value in the list with badge values");
            String itemPlusBadge = listItem + " " + badgeValue;
                // Assert that the second list item's value is set to "List Item 2"
                Assert.assertEquals(listItems.get(indexOfListElement).getText().trim(), itemPlusBadge,"List item doesn't match with the provided parameters");
                logger.info("List item match with the provided parameters");

                    // Assert that the second list item's badge value is 6
                    WebElement badge = listItems.get(indexOfListElement).findElement(By.cssSelector("span.badge"));
                    Assert.assertEquals(badge.getText().trim(), badgeValue);
                    logger.info("Actual badge value is match with the expected value");
    }

    /**
                        ******************************     TEST 03     ********************************



     * This code is checking the dropdown menu. It first finds the "dropDownVerify" WebElement using the @FindBy annotation,
     * and then finds all the options in the dropdown menu by searching for all elements with xpath "//div[@class='dropdown-menu']/a".

     * It then uses an if statement to loop through the list of options and clicks on the option that matches the "selectOption" parameter.
     * Before that it checks if the dropDownVerify WebElement is displayed, and if the currently selected option matches the expected "expectedVerifyOption".

     * Finally, it uses the Assert class to validate that the actual selected option matches the expected option.
     * If they don't match, the test will fail and an error message will be displayed indicating that the actual selected option doesn't match the expected option.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void setDropDownVerify(String expectedVerifyOption, String selectOption) {

        Browser_Utils.scrollToMiddleOfScreen(getDriver(),getDropDownVerify());
        Browser_Utils.staticWait(2);
                Browser_Utils.waitForElement(getDropDownVerify());
                Assert.assertTrue(getDropDownVerify().isDisplayed(),"Dropdown is not displayed");
                logger.info("Dropdown is displayed");
                    List<WebElement> listOfOptions = getDriver().findElements(By.xpath("//div[@class='dropdown-menu']/a"));
                    getDropDownVerify().click();

            String actualSelectedOption = getDropDownVerify().getText();
                Assert.assertEquals(actualSelectedOption, expectedVerifyOption,"Actual option doesn't match with the expected option");
                logger.info("Actual option match with the expected option");

            Actions actions = new Actions(getDriver());

            for (WebElement option : listOfOptions) {

                String currentValue = option.getText();

                if (currentValue.equals(selectOption)) {

                    Browser_Utils.staticWait(1);
                    actions.click(option).perform();
                        Browser_Utils.staticWait(2);
                        logger.info(selectOption + " Successfully selected from dropdown");
                            break;
                }
            }
        }


    /**
                        ******************************     TEST 04     ********************************

     * This code is checking if two buttons, "enabledButton" and "disabledButton", are enabled or disabled as expected.
     * The first line of the code uses an "assert" statement to check if the first button, "enabledButton", is enabled and to report a message if it's not.

     * The second line checks if the second button, "disabledButton", is not enabled and reports a message if it's not.
     * The purpose of this code is to verify the functionality of these buttons and to ensure that they are enabled or disabled as intended.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void setVerifyEnableAndDisableButton(){
        Browser_Utils.scrollToMiddleOfScreen(getDriver(),getEnabledButton());
        Browser_Utils.staticWait(1);
            Assert.assertTrue(getEnabledButton().isEnabled(), "First Button is not enabled");
            logger.info("First button is enabled");
                Assert.assertTrue(!getDisabledButton().isEnabled(), "Second Button is not disabled");
                logger.info("Second button is disabled");
        }

    /**

                        ******************************     TEST 05     ********************************

     * This code is checking if a button with the id "test5-button" is present on the page using the FindBy annotation.
     * If it is present, the code performs a scroll to bring the button into view and clicks on it.

     * The code uses the fluentWait method from the Browser_Utils class to wait for the button to become clickable before clicking on it.
     * The Actions class is used to perform the scroll action.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void setWaitForButton(){
        Browser_Utils.fluentWait(getDriver(), getWaitForButton());
        Browser_Utils.scrollToMiddleOfScreen(getDriver(),getWaitForButton());
        Browser_Utils.staticWait(2);
            getWaitForButton().click();
            logger.info("Successfully waited for button and clicked it");


        }
        public void setWaitForMessage(){
        Browser_Utils.staticWait(2);
            Assert.assertTrue(getWaitForMessage().isDisplayed());
            logger.info("Info message successfully displayed");
        }


    /**
                            ******************************     TEST 06     ********************************

     *
     * This code is written to retrieve the data from a table and store it in a 2-dimensional array. The array is called "tableData".

     * First, the code counts the number of rows and columns in the table. Then, it creates a 2-dimensional array with the same number of rows and columns as the table.

     * The code then loops through each cell in the table, and retrieves its text. This text is then stored in the corresponding position in the "tableData" array.
     * Finally, the code returns the "tableData" array.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

        public String[][] getTableData() {
            int rowCount = getRows().size();
            int colCount = getCols().size();

            String[][] tableData = new String[rowCount][colCount];

            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < colCount; col++) {
                    WebElement cell = getRows().get(row).findElement(By.cssSelector("td:nth-child(" + (col + 1) + ")"));
                    tableData[row][col] = cell.getText();
                }
            }
            return tableData;
        }



    /**
     *
     * This code is used to validate the data in a table by comparing the actual value in a specific cell with the expected value.
     * If the actual value matches the expected value, the test will pass. If the actual value is different from the expected value,
     * the test will fail. The message "Actual result doesn't match with the expected result" is displayed to help identify the issue.
     *
     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void getCellValue(int row, int col, String expectedResult) {
        String[][] tableData = getTableData();
        String result = tableData[row][col];
            Browser_Utils.scrollToMiddleOfScreen(getDriver(),getHeaderOfTheTable());
            Browser_Utils.staticWait(2);

                Assert.assertEquals(result,expectedResult,"Actual result doesn't match with the expected result");
                logger.info("Data that in the row number :" + row + " and col number in the :" + col + " is match with the expected result :" + expectedResult);

    }


}



