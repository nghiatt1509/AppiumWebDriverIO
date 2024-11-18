package com.elfie;

import com.elfie.helper.ConfigReader;
import com.elfie.pages.ChromePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriverLocalService appiumDriverLocalService;
    protected AndroidDriver androidDriver;
    protected ChromePage chromePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        setUpAppium();

        // Initialize Page Object
        chromePage = new ChromePage(androidDriver);
    }

    @AfterClass
    public void tearDown(){
        if (androidDriver != null)
            androidDriver.quit();

        if (appiumDriverLocalService != null)
            appiumDriverLocalService.stop();
    }

    private void setUpAppium() throws MalformedURLException{
        ConfigReader configReader = new ConfigReader("src/config.properties");

        // Get property values
        String deviceName = configReader.getProperty("deviceName");
        String platformName = configReader.getProperty("platformName");
        String automationName = configReader.getProperty("automationName");
        String browserName = configReader.getProperty("browserName");
        String chromeDriverPath = configReader.getProperty("chromeDriverPath");
        String remoteAddress = configReader.getProperty("remoteAddress");

        //Start Appium Service
        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setPlatformName(platformName);
        options.setAutomationName(automationName);
        options.setCapability(CapabilityType.BROWSER_NAME, browserName);
        options.setCapability("chromedriverExecutable", chromeDriverPath);

        // Initialize AndroidDriver
        androidDriver = new AndroidDriver(new URL(remoteAddress), options);
    }
}
