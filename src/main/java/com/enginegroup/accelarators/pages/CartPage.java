package com.enginegroup.accelarators.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import static com.enginegroup.accelarators.pages.LoginPage.page;

@DefaultUrl("page:cart.page")
public class CartPage extends PageObject {

    public static String checkoutStepOneUrl = "checkout-step-one.html";

    public void clickShoppingCartAndClickCheckoutButton() {
        $(WebpageElements.shoppingCartXpath).waitUntilVisible();
        $(WebpageElements.shoppingCartXpath).click();
        $(WebpageElements.cartDescLabelXpath).waitUntilVisible();
        $(WebpageElements.continueShoppingButtonXpath).waitUntilVisible();
        $(WebpageElements.checkoutButtonXpath).waitUntilVisible();
        page.waitUntilElementIsClickable("#checkout.btn.btn_action.btn_medium.checkout_button");
        page.assertCurrentPageUrl(checkoutStepOneUrl);
    }
}
