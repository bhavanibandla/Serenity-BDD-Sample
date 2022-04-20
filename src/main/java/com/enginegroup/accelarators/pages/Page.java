package com.enginegroup.accelarators.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page extends PageObject {

    public static String baseUrl = "https://www.saucedemo.com";
    public static String checkoutStepOneUrl = baseUrl + "/checkout-step-one.html";

    public String getCurrentPageUrl() {
        String currentPageUrl = getDriver().getCurrentUrl();
        System.out.println("Current Page URL: " + currentPageUrl);
        return currentPageUrl;
    }

    public List<WebElementFacade> getItemsList() {
        return findAll(WebpageElements.productsXpath);
    }

    public void navigateToSpecificUrl() {
        getDriver().navigate().to(checkoutStepOneUrl);
    }

    public void assertCurrentPageUrl(String propertyKey) {
        String expectedUrl = baseUrl + "/" + propertyKey;
        Assert.assertEquals(expectedUrl, this.getCurrentPageUrl());
    }

    public void verifyAndClickUsingJS(String locator) {
        WebElement element = getDriver().findElement(By.cssSelector(locator));
        JavascriptExecutor ex = (JavascriptExecutor) getDriver();
        if (element.isEnabled()) {
            System.out.println("Element is enabled for user clicks!");
            ex.executeScript("arguments[0].click()", element);
            this.navigateToPageUsingEventDriver();
        } else {
            this.navigateToPageUsingEventDriver();
        }
    }

    public void navigateToPageUsingEventDriver() {
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(getDriver());
        eventDriver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void waitUntilElementIsClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        JavascriptExecutor ex = (JavascriptExecutor) getDriver();
        ex.executeScript("arguments[0].click()", element);
    }

    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(getDriver -> getDriver().findElement(locator));

        return  foo;
    }
}
