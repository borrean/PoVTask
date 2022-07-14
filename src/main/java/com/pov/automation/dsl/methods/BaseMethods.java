package com.pov.automation.dsl.methods;

import com.pov.automation.dsl.interfaces.Button;
import com.pov.automation.dsl.interfaces.Element;
import com.pov.automation.dsl.interfaces.Field;
import com.pov.automation.essentials.testng.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class BaseMethods extends BaseTest implements Element, Button, Field, WebElement {
    protected final WebDriver driver;
    protected final Logger log;

    public WebDriver getDriver() {
        return driver;
    }

    public BaseMethods(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    @Override
    public void Click(By locator) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click();
        }catch(WebDriverException e){
            throw new ElementNotInteractableException("Element" +locator+ "cannot be clicked");
        }
    }

    @Override
    public void Write(String text, By locator) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
        }catch(WebDriverException e){
            throw new ElementNotInteractableException("Element" +locator+ " cannot receive input.");
        }
    }

    @Override
    public String Read(By locator) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        }catch(WebDriverException e){
            throw new ElementNotVisibleException("Unable to get value from " +locator+ " element.");
        }}

    @Override
    public void Exists(int timeout, By locator) {
        try{
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        log.info("Element " +locator+ " is visible.");
        }catch(WebDriverException e){
            throw new ElementNotVisibleException("Element" +locator+ " not visible.");
        }
    }

    @DataProvider(name="files")
    protected static Object[][] files() {
        return new Object[][] {
                {1,"index.html"},
                {2,"logo.png"},
                {3,"text.txt"}
        };
    }

    /** Take screenshot */
    protected void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + getTodaysDate()
                + File.separator + testSuiteName
                + File.separator + testName
                + File.separator + testMethodName
                + File.separator + getSystemTime()
                + " " + fileName + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Todays date in yyyyMMdd format */
    private static String getTodaysDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    /** Current time in HHmmssSSS */
    private String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }

    /** Get logs from browser console */
    protected List<LogEntry> getBrowserLogs() {
        LogEntries log = driver.manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;
    }

    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        
    }

    @Override
    public void clear() {}

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
