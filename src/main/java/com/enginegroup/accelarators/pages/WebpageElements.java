package com.enginegroup.accelarators.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class WebpageElements extends PageObject {

    @FindBy(css="#user-name")
    public static WebElementFacade userNameCss;

    @FindBy(css = "#checkout.btn.btn_action.btn_medium.checkout_button")
    public static WebElementFacade checkoutBtnCss;

    public static By usernameXpath = By.xpath("//*[@id=\"user-name\"]");
    public static By passwordXpath = By.xpath("//*[@id=\"password\"]");
    public static By loginButtonXpath = By.xpath("//*[@id=\"login-button\"]");
    public static By pageTextToVerify = By.xpath("//*[@class=\"title\"]");
    public static By errorMsgXpath = By.xpath("//*[@data-test=\"error\"]");
    public static By burgerMenuXpath = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    public static By logoutXpath = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    public static By shoppingCartXpath = By.xpath("//*[@id=\"shopping_cart_container\"]");
    public static By cartDescLabelXpath = By.xpath("//*[@class=\"cart_desc_label\"]");
    public static By removeButtonXpath = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");
    public static By checkoutButtonXpath = By.cssSelector("#checkout.btn.btn_action.btn_medium.checkout_button");
    public static By continueShoppingButtonXpath = By.xpath("//*[@id=\"continue-shopping\"]");
    public static By continueButtonXpath = By.xpath("//*[@id=\"continue\"]");
    public static By cancelButtonXpath = By.xpath("//*[@id=\"cancel\"]");
    public static By firstNameXpath = By.xpath("//*[@id=\"first-name\"]");
    public static By lastNameXpath = By.xpath("//*[@id=\"last-name\"]");
    public static By postalCodeXpath = By.xpath("//*[@id=\"postal-code\"]");
    public static By productsXpath = By.cssSelector("div.inventory_item_description div.pricebar button");
    public static By removeItemXpath = By.xpath(" //*[@id=\"remove-sauce-labs-backpack\"]");
    public static By itemCountXpath = By.xpath("//*[@class=\"shopping_cart_badge\"]");
    public static By cartContainerXpath = By.xpath("//*[@id=\"shopping_cart_container\"]");
}
