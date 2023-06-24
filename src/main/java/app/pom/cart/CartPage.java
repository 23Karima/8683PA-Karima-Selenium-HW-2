package app.pom.cart;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;

public class CartPage extends BasePage {
    @FindBy(id = "view-cart-button")
    private WebElement viewCartButton;

    @FindBy(id = "proceed-to-checkout-button")
    private WebElement proceedToCheckoutButton;

    public void clickViewCartButton() {
        clickElement(viewCartButton);
    }

    public boolean isCartItemDisplayed() {
        return isElementDisplayed(By.className("cart-item"));
    }

    public void clickProceedToCheckoutButton() {
        clickElement(proceedToCheckoutButton);
    }

    public boolean isCheckoutPageDisplayed() {
        return isElementDisplayed(By.className("checkout-page"));
    }

    public void fillShippingAddress(String name, String address, String city, String zipCode) {
        // Implementation for filling the shipping address fields
        // Replace with your actual logic
    }

    public boolean isOrderConfirmationDisplayed() {
        return isElementDisplayed(By.className("order-confirmation-page"));
    }

    private void clickElement(WebElement element) {
        element.click();
    }

    private boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
