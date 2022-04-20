package com.enginegroup.accelarators.pages;

import com.enginegroup.accelarators.utils.EncryptionUtils;
import com.enginegroup.accelarators.utils.EnginePropertiesUtils;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("page:home.page")
public class LoginPage extends PageObject {

    public static EnginePropertiesUtils dataProperties = new EnginePropertiesUtils();
    public static Page page = new Page();

    public static String pass;

    public String pageTitle = "Swag Labs";
    public String user_encrypt_pass = dataProperties.getProperty("test_user_encrypt_pass");
    public String user_secret_text = dataProperties.getProperty("test_user_secret_text");
    public static String inventoryUrl = "inventory.html";

    public void launchApp() {
        open();
        getDriver().manage().window().maximize();
        waitOnPage();
        waitForTitleToAppear(pageTitle);
        page.assertCurrentPageUrl("");
    }

    public void verifyLoginPageAndLogin(String username, String password) {

        waitForElement();
        page.waitUntilElementIsClickable("#user-name");

        if (username.equals("test_user1") || username.equals("test_user2") || username.equals("test_user3") || username.equals("test_user4")) {
            String test_username = dataProperties.getProperty(username);
            $(WebpageElements.usernameXpath).typeAndEnter(test_username);
        }

        $(WebpageElements.passwordXpath).waitUntilClickable();

        boolean boolValue = password.equalsIgnoreCase("pass1") || password.equalsIgnoreCase("pass2") || password.equalsIgnoreCase("pass3");
        if (boolValue) {
            pass = EncryptionUtils.decrypt(user_encrypt_pass, user_secret_text);
        } else {
            if (username.equalsIgnoreCase("test_user1")) {
                pass = "";
            } else {
                pass = EncryptionUtils.decrypt(user_encrypt_pass, user_secret_text);
            }
        }

        $(WebpageElements.passwordXpath).typeAndEnter(pass);
        $(WebpageElements.loginButtonXpath).click();

        if (boolValue) {
            page.assertCurrentPageUrl(inventoryUrl);
        } else {
            page.assertCurrentPageUrl("");
        }
    }
}
