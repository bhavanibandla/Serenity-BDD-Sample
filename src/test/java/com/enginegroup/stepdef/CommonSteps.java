package com.enginegroup.stepdef;

import com.enginegroup.accelarators.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonSteps {

    @Steps
    public LoginPage loginPage;

    @Steps
    public ProductsPage homePage;

    @Steps
    public ErrorPage errorMsg;

    @Steps
    public LogoutPage logoutPage;

    @Steps
    public CartPage cartPage;

    @Steps
    public CheckoutOnePage checkoutOnePage;

    @Given("^the user is on login page$")
    public void launchWebApp() {
        loginPage.launchApp();
    }

    @When("^the user enters (valid|invalid) username as (.*) and (valid|invalid) password as (.*)$")
    public void verifyLoginPageAndLoginWithValidCredentials(String ignoredValidOrInvalidUsername, String username, String ignoredValidOrInvalidPassword, String password) {
        loginPage.verifyLoginPageAndLogin(username, password);
    }

    @And("^the user verifies error message (.*) on login page$")
    public void verifyErrorMessageOnLoginPage(String errorMsgText) {
        errorMsg.verifyErrorMsgOnLoginPage(errorMsgText);
    }

    @And("^the user verifies home page post login$")
    public void verifyHomePagePostLogin() {
        homePage.verifyProductsPagePostLogin();
    }

    @And("^the user clicks add to cart button randomly on the products page to an item$")
    public void randomlyClicksAddToCartButtonToAddAProductToCart() {
        homePage.randomlyClicksAddToCartButtonToAddAProductToCart();
    }

    @And("^the user clicks shopping cart icon and clicks checkout button$")
    public void clickShoppingCartAndClickCheckoutButton() {
        cartPage.clickShoppingCartAndClickCheckoutButton();
    }

    @And("^the user clicks continue button without entering full (.*) details$")
    public void clickContinueButtonWithoutEnteringFullUserDetails(String user_details) {
        checkoutOnePage.clickContinueButtonWithoutEnteringFullUserDetails(user_details);
    }

    @And("^the user enter details and click continue to final checkout page$")
    public void enterDetailsAndClickContinueButtonToSeeFinalCheckoutPage() {
        checkoutOnePage.verifyShoppingCartAndEnterUserDetails("xyz", "abc", "000000");
    }

    @And("^the user verifies error message (.*) on shopping cart page$")
    public void verifyErrorMessageOnShoppingCartPage(String errorMsgText) {
        errorMsg.verifyErrorMsgOnShoppingCartPage(errorMsgText);
    }

    @Then("^the user clicks burger menu and click logout link to terminate the user session$")
    public void clickBurgerMenuAndClickLogoutLink() {
        logoutPage.clickBurgerMenuAndVerifyLogoutLink();
        logoutPage.clickLogoutLink();
    }
}
