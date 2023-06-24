package app.pom.checkout;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(id = "checkout-button")
    private WebElement checkoutButton;

    public void proceedToCheckout() {
        // Implementation for proceeding to checkout
        checkoutButton.click();
    }
}