package code.Test_Base;

import code.AAA_Utils.Browser_Utils;
import code.AAA_Utils.ConfigurationReader;
import code.AAA_Utils.Driver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Test_Base extends Browser_Utils {

    private static final Logger logger = Logger.getLogger(Test_Base.class);

    @BeforeTest
    public void setup(){

        // The first line //
        /**

         * WebDriver_Utils.getDriver().get(Properties_Utils.getProperties("url"));
         * opens the specified web page in the browser. The URL of the web page is retrieved from a configuration file. **/

        // The second line //
        /** WebDriver_Utils.getDriver().manage().window().maximize(); makes the browser window full screen. **/

         // The third line //
         /**

          * WebDriver_Utils.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); sets a time-out value for the browser, \
          * telling it to wait for up to 15 seconds for elements to load on the web page before continuing with the test. **/

          /**
           *
           This code is opening a web page in a full-screen browser, and setting a time-out value to ensure the
           elements of the page have enough time to load before the test continues.
           *
           **/
        // ↓ ↓ ↓ ↓ ↓ ↓ ↓
        /**  Reusable with the UTILS **/
        Driver.getDriver().get(ConfigurationReader.getProperties("url"));
        BasicConfigurator.configure();

        if (Driver.getDriver() == null){
            logger.error("When driver started it got failed");
        }

        logger.info("Driver successfully started");

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

          /**  Hardcode without the UTILS **/
//
//        driver = WebDriverUtil.getDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
        /**
         *
         This code is used to clean up the resources created during the test run, and to close any open web browsers
         *
         **/
        // ↓ ↓ ↓ ↓ ↓ ↓ ↓
    @AfterTest
    public void tearDown(){
        logger.info("Driver successfully cleaned up");
        Driver.tearDown();


    }
}
