package code.Base_Page;

import code.AAA_Utils.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    /**
     *
     It's making sure that the test code waits for up to 60 seconds for a specific page element to appear or load before it continues to execute
     the next steps of the test. This waiting mechanism is useful in ensuring that the test code doesn't proceed too quickly, and can catch any unexpected delays or
     loading times in the application being tested.
     *
     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    WebDriverWait driverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));

    /**
    *
    This code is setting up the foundation for testing a webpage by making sure certain parts of it are ready to be used in the tests.
    *
    **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);}
}
