package com.enginegroup.webdrivermanager.localwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ChromeDriver {
    public ChromeDriver() {
        this.setupClass();
    }
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public WebDriver driverSetupTest() {
        return new org.openqa.selenium.chrome.ChromeDriver();
    }
}
