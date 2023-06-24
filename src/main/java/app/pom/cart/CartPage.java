package app.pom.cart;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(id = "view-cart-button")
    private WebElement viewCartButton;

    @FindBy(id = "proceed-to-checkout-button")
    private WebElement proceedToCheckoutButton;

    public void clickViewCartButton() {
        // Implementation for clicking the View Cart button
        clickElement(viewCartButton);
    }

    public boolean isCartItemDisplayed() {
        // Implementation to check if the cart item is displayed
        return isElementVisible(By.className("cart-item"));
    }

    public void clickProceedToCheckoutButton() {
        // Implementation for clicking the Proceed to Checkout button
        clickElement(proceedToCheckoutButton);
    }

    public boolean isCheckoutPageDisplayed() {
        // Implementation to check if the checkout page is displayed
        return isElementVisible(By.className("checkout-page"));
    }

    public void fillShippingAddress(String name, String address, String city, String zipCode) {
        // Implementation for filling the shipping address fields
        // Replace with your actual logic
    }

    public boolean isOrderConfirmationDisplayed() {
        // Implementation to check if the order confirmation page is displayed
        return isElementVisible(By.className("order-confirmation-page"));
    }

    private void clickElement(WebElement element) {
        element.click();
    }

    private boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}