package code.Tests;

import code.AAA_Utils.Browser_Utils;
import code.AAA_Utils.ConfigurationReader;
import code.AAA_Utils.Driver;
import code.Page_Objects.Home_Page;
import code.Test_Base.Test_Base;
import org.testng.annotations.Test;

public class HomeTests extends Test_Base {

    @Test(description = "Test 01" , priority = 1,testName = "Test 01")
    public void TC_101_verifyEmailPasswordAndSignIn() {
        Browser_Utils.validateTitle(Driver.getDriver().getTitle(),"Home");
            Home_Page home_page = new Home_Page();
                home_page.setVerifyEmailBox();
                home_page.setVerifyPasswordBox();
                home_page.setVerifySignIn();
                Browser_Utils.staticWait(2);
    }

    @Test(description = "Test 01" , priority = 2,testName = "Test 02")
    public void TC_101_signInWithCorrectCredentials() {

        Browser_Utils.validateTitle(Driver.getDriver().getTitle(),"Home");
            Home_Page home_page = new Home_Page();
                 home_page.setSignInWithCorrectCredentials( ConfigurationReader.getProperties("email"),
                                                            ConfigurationReader.getProperties("password"));

    }

    @Test(description = "Test 02", priority = 3,testName = "Test 03")
    public void TC_102_verifyListItemAndBadgeValue(){
        Browser_Utils.validateTitle(Driver.getDriver().getTitle(),"Home");
            Home_Page home_page = new Home_Page();
                home_page.setListGroup("List Item 2", "6", 3,1);
    }

    @Test(description = "Test 03",priority = 4,testName = "Test 04")
    public void TC_103_verifyDropdown(){
        Browser_Utils.validateTitle(Driver.getDriver().getTitle(),"Home");
            Home_Page home_page = new Home_Page();
                home_page.setDropDownVerify("Option 1","Option 3");
    }

    @Test(description = "Test 04", priority = 5,testName = "Test 05")
    public void TC_104_verifyFirstButtonAndSecondButton(){
        Browser_Utils.validateTitle(Driver.getDriver().getTitle(),"Home");
            Home_Page home_page = new Home_Page();
                home_page.setVerifyEnableAndDisableButton();
    }

    @Test(description = "Test 05", priority = 6,testName = "Test 06")
    public void TC_105_waitForButtonAndVerifyMessage(){
        Browser_Utils.validateTitle(Driver.getDriver().getTitle(),"Home");
            Home_Page home_page = new Home_Page();
                home_page.setWaitForButton();
                home_page.setWaitForMessage();
    }

    @Test(description = "Test 06", priority = 7,testName = "Test 07")
    public void TC_106_verifyTableInput(){
        Browser_Utils.validateTitle(Driver.getDriver().getTitle(),"Home");
            Home_Page home_page = new Home_Page();
                home_page.getCellValue(2,2,"Ventosanzap");
    }
}
