package com.pov.automation.essentials.testng;

import com.pov.automation.essentials.driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    protected String testName;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public boolean setUp(String browser,ITestContext ctx) {
        log = LogManager.getLogger(testName);
        DriverFactory factory = new DriverFactory(browser, log);
        driver = factory.createDriver();
        driver.manage().window().maximize();
        return true;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}
