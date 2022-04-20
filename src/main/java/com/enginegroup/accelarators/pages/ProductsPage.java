package com.enginegroup.accelarators.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import static com.enginegroup.accelarators.pages.LoginPage.page;

public class ProductsPage extends PageObject {

    public static String inventoryUrl = "inventory.html";

    public void verifyProductsPagePostLogin() {
        waitForElement();
        $(WebpageElements.pageTextToVerify).waitUntilVisible();
        page.assertCurrentPageUrl(inventoryUrl);
    }

    public void randomlyClicksAddToCartButtonToAddAProductToCart() {
        $(WebpageElements.productsXpath).waitUntilVisible();
        for (WebElement element : page.getItemsList()) {
            waitFor(element).isClickable();
            if (!element.getText().equals("REMOVE")) {
                System.out.println("Element text: " + element.getText());
                element.click();
            }
            if ($(WebpageElements.cartContainerXpath).getText() != null) {
                System.out.println("Cart Count Number: " + $(WebpageElements.cartContainerXpath).getText());
                int currentItemCount = Integer.parseInt($(WebpageElements.cartContainerXpath).getText());
                if (currentItemCount >= 1) {
                    break;
                } else {
                    System.out.println("No items in the cart!");
                }
            }
        }
        page.assertCurrentPageUrl(inventoryUrl);
    }
}
