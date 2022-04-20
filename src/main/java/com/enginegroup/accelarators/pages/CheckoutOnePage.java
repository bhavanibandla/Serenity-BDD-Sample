package com.enginegroup.accelarators.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import static com.enginegroup.accelarators.pages.LoginPage.page;

@DefaultUrl("page:checkout.step.one.page")
public class CheckoutOnePage extends PageObject {

    public static String checkoutStepOneUrl = "checkout-step-one.html";

    public void verifyShoppingCartAndEnterUserDetails(String firstname, String lastname, String postalcode) {
        page.assertCurrentPageUrl(checkoutStepOneUrl);
        $(WebpageElements.firstNameXpath).waitUntilVisible();
        $(WebpageElements.firstNameXpath).typeAndEnter(firstname);
        $(WebpageElements.lastNameXpath).waitUntilVisible();
        $(WebpageElements.lastNameXpath).typeAndEnter(lastname);
        $(WebpageElements.postalCodeXpath).waitUntilVisible();
        $(WebpageElements.postalCodeXpath).typeAndEnter(postalcode);
        this.clickContinueButtonToProceedToFinalCheckoutPage();
        page.assertCurrentPageUrl(checkoutStepOneUrl);
    }

    public void clickContinueButtonWithoutEnteringFullUserDetails(String user_details) {
        page.assertCurrentPageUrl(checkoutStepOneUrl);
        String[] user_details_list = user_details.split(",");
        for (String str_to_fill : user_details_list) {
            if (str_to_fill.contains("first_name")) {
                $(WebpageElements.firstNameXpath).typeAndEnter("XYZ");
            } else if (str_to_fill.contains("last_name")) {
                $(WebpageElements.lastNameXpath).typeAndEnter("ABC");
            } else if (str_to_fill.contains("postal_code")) {
                $(WebpageElements.postalCodeXpath).typeAndEnter("99999");
            }
        }
        this.clickContinueButtonToProceedToFinalCheckoutPage();
        page.assertCurrentPageUrl(checkoutStepOneUrl);
    }

    public void clickContinueButtonToProceedToFinalCheckoutPage(){
        $(WebpageElements.cancelButtonXpath).waitUntilVisible();
        $(WebpageElements.continueButtonXpath).waitUntilClickable();
        $(WebpageElements.continueButtonXpath).click();
    }
}
