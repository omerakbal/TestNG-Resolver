package code.AAA_Utils;


import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

/**
    *
    This code is used to pause the execution of a program for a specific number of seconds.
    It can be useful in situations where a user needs to wait for a certain amount of time before proceeding with the next step in the program.
    *
    **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

public class Browser_Utils {

    /**

     This line creates a tool for recording messages about what's happening in the "Browser_Utils" class in a computer program.
     These messages can be information, warnings, or errors. The tool is called a "logger" and it is private, static, and cannot be changed once created.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    private static final Logger logger = Logger.getLogger(Browser_Utils.class);

    /**

     This code is just a "wait" function for a computer program. It takes in a number of seconds and makes the program
     pause for that amount of time. This is useful if you want the program to wait before doing something else.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    public static void staticWait(int second){
        try{
            Thread.sleep(1000*second);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

        /**

         This code is used to validate if the actual title of a web page matches the expected title.
         If the titles do not match, an error message is displayed indicating that the actual title doesn't match
         the expected title, and the actual title is also displayed in the error message.

         **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    public static void validateTitle(String actual, String expected){
        Assert.assertEquals(actual,expected, "Actual title doesn't match with the expected title");
        logger.info("Page title verified");

    }

    /**

     * This code waits for a specific web element to become clickable on a webpage.
     * It waits for up to 10 seconds before continuing with the next step in the automation script.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**

     * This code waits for a specified web element to become visible on a webpage. The code creates a "FluentWait" object,
     * which is a type of wait provided by Selenium, and sets the maximum wait time to 30 seconds and the frequency of checking
     * the visibility of the element to every 5 seconds. If any exceptions occur while checking the visibility of the element, they will be ignored.
     * The code then returns the element once it is visible. This type of wait is necessary when working with dynamic web
     * pages where elements may take some time to load and become visible.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public static WebElement fluentWait(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**

     * This code is written in Java and is used to scroll a web page to the middle of the screen.
     * The input is a web driver and a web element on the page. The code uses JavaScript to change
     * the position of the page to the middle of the screen with respect to the web element passed as input.
     * The web driver is cast as a JavaScript executor to allow the JavaScript code to be executed in the context of the web page.

     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    public static void scrollToMiddleOfScreen(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("window.scroll(0, arguments[0].getBoundingClientRect().top - (window.innerHeight / 2));", element);
    }
}

