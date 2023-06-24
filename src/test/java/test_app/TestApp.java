package test_app;

import app.pom.homepage.Homepage;
import app.pom.cart.CartPage;
import app.pom.product.ProductPage;
import app.pom.search.SearchPage;
import base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestApp extends BasePage {
    @Test(priority = 0, groups = {"BAT"}, enabled = true)
    public void testNavigationToApplication() {
        // Test Case 1: Navigation to Application (Verify that the application is accessible)

        Homepage homepage = new Homepage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }


    @Test(priority = 1, groups = {"BAT"}, enabled = false)
    public void testSearchBar() throws InterruptedException {
        // Test Case 2: Item Search using Search Bar
        testNavigationToApplication();

        Homepage homepage = new Homepage();
        SearchPage searchPage = new SearchPage();

        String searchTerm = "legging";

        Assert.assertTrue(isElementVisible(homepage.searchBar));
        homepage.searchForItem(searchTerm);
        //driver.findElement(By.xpath("//button[@title='Search']")).click();
        clickOnElement(homepage.searchBtn);

        Thread.sleep(5000);

        Assert.assertTrue(searchPage.areSearchResultsDisplayed());
        //Assert.assertTrue(searchPage.isSearchTermHighlighted(searchTerm));
    }

    @Test(priority = 2, groups = {"BAT"}, enabled = true)
    public void testAddItemToCart() throws InterruptedException {
        // Test Case 3: Add Item to Cart (Verify that an item can be added to the cart)

        testSearchBar();

        Homepage homepage = new Homepage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        // Steps to add item to cart
        homepage.searchForItem("legging");
        productPage.addItemToCart();

        // Assertion for the added item
        Assert.assertTrue(cartPage.isCartItemDisplayed());
    }

    @Test(priority = 3, groups = {"BAT"}, enabled = false)
    public void testCheckoutProcess() {
        // Test Case 4: Checkout Process (Verify that the user can complete the checkout process)

        CartPage cartPage = new CartPage();

        // Steps to proceed to checkout
        cartPage.clickViewCartButton();
        cartPage.clickProceedToCheckoutButton();

        // Assertion for the checkout page
        Assert.assertTrue(cartPage.isCheckoutPageDisplayed());

        // Steps to complete the checkout process
        cartPage.fillShippingAddress("Karima Mohammed", "534 Moon", "Pittsburgh", "12345");
        // ... Fill in additional steps as required

        // Assertion for the order confirmation
        Assert.assertTrue(cartPage.isOrderConfirmationDisplayed());
    }

}
