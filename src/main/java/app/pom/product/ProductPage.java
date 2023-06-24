package app.pom.product;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    public void addItemToCart() {
        // Implementation for adding the item to the cart
        addToCartButton.click();
    }
}