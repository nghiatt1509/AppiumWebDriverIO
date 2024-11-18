package com.elfie.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ChromePage extends BasePage{

    // Chrome Element Locators
    private By searchBox = By.xpath("//textarea[@title]");
    private By firstResult = By.xpath("//div[h2]");
    private By elfieLogo = By.xpath("//img[@alt='Elfie Logotype']");
    private By hamburgerMenu = By.xpath("//div[@aria-label='menu'][@aria-expanded='false']");
    private By xButton = By.xpath("//div[@aria-label='menu'][@aria-expanded='true']");
    private By copyrightText = By.xpath("//div[@class='text-block']");

    public ChromePage(AndroidDriver androidDriver){
        super(androidDriver);
        this.webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
    }

    public void openUrl(String strUrl){
        androidDriver.get(strUrl);
        slowdowTest(5);
    }

    public void searchKeyword(String strKeyword){
        enterTextInToElement(searchBox, strKeyword);
        actionOnElement(searchBox, Keys.ENTER);
    }

    public void clickFirstResult(){
        clickElement(firstResult);
    }

    public boolean isLogoDisplayed(){
        return isElementDisplayed(elfieLogo);
    }

    public void clickHamburgerMenu(){
        clickElement(hamburgerMenu);
    }

    public boolean isHamburgerMenuChangedToX(){
        return isElementDisplayed(xButton);
    }

    public boolean isCopyRightTextDisplayed(){
        WebElement copyRightTextElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(copyrightText));
        return copyRightTextElement.getText().equals("Copyright © 2024 Elfie Pte. Ltd.");
    }
}