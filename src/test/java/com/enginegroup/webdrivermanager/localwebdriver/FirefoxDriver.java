package com.enginegroup.webdrivermanager.localwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class FirefoxDriver {
    public FirefoxDriver() {
        this.setupClass();
    }
    public void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    public WebDriver driverSetupTest() {
        return new org.openqa.selenium.firefox.FirefoxDriver();
    }
}
