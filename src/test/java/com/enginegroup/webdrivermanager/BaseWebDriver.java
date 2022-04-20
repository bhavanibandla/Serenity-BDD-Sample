package com.enginegroup.webdrivermanager;

import com.enginegroup.webdrivermanager.localwebdriver.ChromeDriver;
import com.enginegroup.webdrivermanager.localwebdriver.FirefoxDriver;
import com.enginegroup.webdrivermanager.remotewebdriver.LambdaTestSerenityDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

public class BaseWebDriver implements DriverSource {
    public static WebDriver driver;
    public static ChromeDriver chromeDriver = new ChromeDriver();
    public static FirefoxDriver firefoxDriver = new FirefoxDriver();
    public static LambdaTestSerenityDriver ltRemoteDriver = new LambdaTestSerenityDriver();

    public WebDriver newDriver() {

        String browserName = System.getProperty("browser");
        System.out.println("Test Runs on local: " + browserName + " browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("Test Runs on local: " + browserName + " browser");
            driver = chromeDriver.driverSetupTest();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("Test Runs on local: " + browserName + " browser");
            driver = firefoxDriver.driverSetupTest();
        } else {
            System.out.println("Test Runs on lambdatest: " + browserName + " browser");
            driver = ltRemoteDriver.newDriver();
        }
        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
