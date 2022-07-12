package com.pov.automation.dsl.methods;

import com.pov.automation.dsl.interfaces.Button;
import com.pov.automation.dsl.interfaces.Element;
import com.pov.automation.dsl.interfaces.Field;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BaseMethods implements Element, Button, Field, WebElement {
    protected final WebDriver driver;
    protected final Logger log;


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
            return element.getAttribute("value");
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
    public void clear() {

    }

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
