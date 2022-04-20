package com.enginegroup.accelarators.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import static com.enginegroup.accelarators.pages.LoginPage.dataProperties;
import static com.enginegroup.accelarators.pages.LoginPage.page;

public class ErrorPage extends PageObject {

    public static String checkoutStepOneUrl = "checkout-step-one.html";

    public void verifyErrorMsgOnLoginPage(String errorMsg) {
        this.verifyErrorMessage(errorMsg);
    }

    public void verifyErrorMsgOnShoppingCartPage(String errorMsg) {
        this.verifyErrorMessage(errorMsg);
    }

    public void verifyErrorMessage(String errorMsg) {
        $(WebpageElements.errorMsgXpath).waitUntilVisible();
        if (errorMsg.equals("error_msg_text1") || errorMsg.equals("error_msg_text2") || errorMsg.equals("error_msg_text3") || errorMsg.equals("error_msg_text4") || errorMsg.equals("error_msg_text5")) {
            String error_text_msg = dataProperties.getProperty(errorMsg);
            Assert.assertEquals(error_text_msg, $(WebpageElements.errorMsgXpath).getText());
        }
        if (errorMsg.equals("error_msg_text1") || errorMsg.equals("error_msg_text2") || errorMsg.equals("error_msg_text4")) {
            page.assertCurrentPageUrl("");
        } else {
            page.assertCurrentPageUrl(checkoutStepOneUrl);
        }
    }
}
