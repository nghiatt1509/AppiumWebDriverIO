package com.elfie.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BasePage {
    protected AndroidDriver androidDriver;
    protected  WebDriverWait webDriverWait;

    // Constructor to initialize the driver
    public BasePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        this.webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
    }

    public WebElement waitForElementPresent(By element){
        System.out.println(String.format("Waiting for element %s present", element.toString()));
        WebElement foundElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
        return foundElement;
    }
    public WebElement waitForElementClickable(By element){
        System.out.println(String.format("Waiting for element %s present", element.toString()));
        WebElement clickableElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        return clickableElement;
    }

    public void clickElement(By element){
        WebElement expectedElement = waitForElementClickable(element);
        System.out.println(String.format("Trying to click element %s", element.toString()));
        expectedElement.click();
        slowdowTest(3);
    }

    public void enterTextInToElement(By element, String text){
        System.out.println(String.format("Trying to set '%s' into element %s", text, element.toString()));
        WebElement textfield = waitForElementPresent(element);
        textfield.sendKeys(text);
        slowdowTest(2);
    }

    public void slowdowTest(long second){
        try {
            System.out.println(String.format("Waiting %s seconds to stablize the test", second));
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollToBottom(){
        androidDriver.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void actionOnElement(By element, Keys keyActions){
        System.out.println(String.format("Trying to '%s' on element %s", keyActions.name(), element.toString()));
        WebElement expectedElement = waitForElementPresent(element);
        expectedElement.sendKeys(keyActions);
        slowdowTest(2);
    }

    public boolean isElementDisplayed(By element) {
        boolean isDisplayed = true;
        try {
            WebElement expectedElement = waitForElementPresent(element);
            isDisplayed = expectedElement.isDisplayed();
        } catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return isDisplayed;
    }

    public void captureScreenshot(String fileName){
        System.out.println(String.format("Capturing screenshot with name: '%s'", fileName));
        androidDriver.getScreenshotAs(OutputType.FILE).renameTo(new File("testElfieAppSearch_copyright_displayed.png"));
    }
}
