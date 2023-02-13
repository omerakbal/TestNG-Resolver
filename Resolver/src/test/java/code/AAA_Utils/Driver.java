package code.AAA_Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    private static WebDriver driver;

        /**
         *
         This code sets up a web driver that can be used to automate interactions with a web browser during an automated test.
         The specific browser to be used is specified in a configuration file and can be either Chrome, Firefox, or a headless version of either Chrome or Firefox.
         *
         **/
        // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    public static WebDriver getDriver(){
        if(driver==null){
            String browser= ConfigurationReader.getProperties("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
            }
        }
        return driver;
    }
    /**
     *
     This code closes the web browser and cleans up any resources used during the automated test.
     This helps to ensure that each test is run in a fresh and isolated environment, and prevents any interference or conflicts between tests.
     *
     **/
    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    public static void tearDown(){

        if (driver!=null)
        {
            driver.close();
            driver = null;
        }
    }
}
