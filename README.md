# AppiumWebDriverIO
AppiumWebDriverIO Challenges

# Necessary Apps:
- NodeJs 10.9.0
- jdk-17.0.4.101-hotspot
- Appium 2.12.1
- Appium Driver: uiautomator2@3.8.3
- Appium Driver: chromium@1.4.4
- Android Studio Ladybug | 2024.2.1 Patch 2
- IntelliJ
- Git
- Chrome 131 apk. Find from: **src/main/resources/apk/** or download at link: [APK Mirror](https://www.apkmirror.com/)
- ChromeDriver. Find from: **src/main/resources/drivers/chromedriver.exe** or download at link: [Download ChromeDriver](https://googlechromelabs.github.io/chrome-for-testing/)
- Appium Java-Client 9.3.0
- TestNG 7.10.2
- Selenium 4.26.0
- Mvn Dependencies

```bash
<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>

    <!-- https://mvnrepository.com/artifact/io.appium/java-client -->
    <dependency>
      <groupId>io.appium</groupId>
      <artifactId>java-client</artifactId>
      <version>9.3.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>7.10.2</version>
      <scope>test</scope>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.26.0</version>
    </dependency>

  </dependencies>
```

# Execute Test:
1. Currently this challenge just work for Android
2. Connect your devive to laptop or try to start emulator
3. Checkout the sourcecode and open with IntelliJ
4. Try to modify the configuration in **config.properties** file from **src/config.properties** as below

```bash
remoteAddress=http://127.0.0.1:4723/
deviceName=<realDevices/emulatorDevice>
platformName=Android
automationName=UiAutomator2
browserName=Chrome
chromeDriverPath=<Locate your ChromeDriver and input the full path to find the chromedriver.exe>
```

5. Open ElfieTest class from **src/test/java/com/elfie/ElfieTest.java** and try to run **testElfieAppSearch**
