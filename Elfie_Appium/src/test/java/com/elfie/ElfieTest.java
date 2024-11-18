package com.elfie;

import com.elfie.helper.ConfigReader;
import com.elfie.pages.ChromePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IBaseBeforeAfter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ElfieTest extends BaseTest{

    @Test
    public void testElfieAppSearch(){

        // 1. Open Chrome and navigate to Google
        chromePage.openUrl("https://www.google.com/");

        // 2. Search for the keyword 'Elfie'
        chromePage.searchKeyword("Elfie");

        // 3. Click on the first returned result
        chromePage.clickFirstResult();

        // 4. Verify the logo is displayed and capture an image
        Assert.assertTrue(chromePage.isLogoDisplayed(), "Logo is not displayed");
        chromePage.captureScreenshot("testElfieAppSearch_logo_displayed.png");

        // 5. Click Hamburger menu and Verify the change
        chromePage.clickHamburgerMenu();
        Assert.assertTrue(chromePage.isHamburgerMenuChangedToX(), "X Button is not displayed");
        chromePage.captureScreenshot("testElfieAppSearch_XButton_displayed.png");

        // 6. Scroll to the bottom and verify copyright text
        chromePage.scrollToBottom();
        Assert.assertTrue(chromePage.isCopyRightTextDisplayed(), "Copyright Text is not displayed");
        chromePage.captureScreenshot("testElfieAppSearch_XButton_displayed.png");
    }
}
