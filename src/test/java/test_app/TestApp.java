package test_app;

import app.pom.homepage.Homepage;
import app.pom.product.ProductPage;
import app.pom.registration.Registration;
import app.pom.authentication.LogInThePage;
import app.pom.authentication.LogInWithInvalidPassword;
import app.pom.cart.CartPage;
import app.pom.search.SearchPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestApp extends BasePage {
    @Test(priority = 0, groups = {"BAT"}, enabled = true)
    public void testNavigationToApplication() {
        // Test Case 1: Navigation to Application (Verify that the application is accessible)

        Homepage homepage = new Homepage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }

    @Test(priority = 2, groups = {"BAT"})
    public void testDoSearch() {
        Homepage homepage = new Homepage();
        String[] searchTerms = ExcelData.readStringArray("testDoSearch");
        String searchTerm = searchTerms[0];

        SearchPage searchPage = homepage.doSearch(searchTerm);
        Assert.assertTrue(isElementVisible(searchPage.textSearchTerm));
    }

    @Test(priority = 3, groups = {"BAT"}, dataProviderClass = data_providers.DataProviders.class, dataProvider = "testDoSearch")
    public void testDoSearch(String searchTerm) {
        Homepage homepage = new Homepage();
        SearchPage searchPage = homepage.doSearch(searchTerm);
        Assert.assertTrue(isElementVisible(searchPage.textSearchTerm));
    }

    @Test(priority = 4, groups = {"BAT"})
    public void testDoSearchWithInvalidSearchTerm() {
        Homepage homepage = new Homepage();
        String searchTerm = "@#$^";
        SearchPage searchPage = homepage.doSearch(searchTerm);
        Assert.assertTrue(isElementVisible(searchPage.resultInvalidSearchTerm));
    }

    @Test(priority = 5, groups = {"BAT"}, enabled = true)
    public void testRegistration() throws InterruptedException {
        testNavigationToApplication();
        Registration registrationPage = new Registration();

        String firstName = "Karima";
        String lastName = "Ait Mohammed";
        String email = "fadma@gmail.com";
        String password = "Karima@23";

        registrationPage.doRegistration(firstName, lastName, email, password);

        Assert.assertTrue(isElementVisible(registrationPage.registrationResultText));
    }

    @Test(priority = 6, groups = {"BAT"}, enabled = true)
    // Test Case 3: Test Login With Valid Password
    public void testLogInWithValidPassword() throws InterruptedException {
        testRegistration();

        LogInThePage logInPage = new LogInThePage();
        String validEmail = "fadma@gmail.com";
        String validPassword = "Karima@23";
        logInPage.getLogIn(validEmail, validPassword);
        Assert.assertTrue(isElementVisible(logInPage.resultLoginMessage));
    }

    @Test(priority = 7, groups = {"BAT"}, enabled = true)
    // Test Case 5: Test Login With Invalid Password
    public void testLogInWithInvalidPassword() {

        LogInWithInvalidPassword logInWithInvalidPassword = new LogInWithInvalidPassword();
        String invalidEmail = "fadma@gmail.com";
        String invalidPassword = "Noura124";
    }

    @Test(priority = 8, groups = {"BAT"}, enabled = false)
    // Test Case 7: Item Search using Search Bar
    public void testSearchBar() throws InterruptedException {

        Homepage homepage = new Homepage();
        SearchPage searchPage = new SearchPage();

        String searchTerm = "legging";

        Assert.assertTrue(isElementVisible(homepage.searchBar));
        homepage.searchForItem(searchTerm);
        clickOnElement(homepage.searchBtn);

        Thread.sleep(5000);

        Assert.assertTrue(searchPage.areSearchResultsDisplayed());
    }

    @Test(priority = 9, groups = {"BAT"}, enabled = true)
    public void testLoginWithInvalidPassword() throws InterruptedException {
        testRegistration();
        LogInWithInvalidPassword logInWithInvalidPassword = new LogInWithInvalidPassword();
        String invalidEmail = "s1330975@gmail.com";
        String invalidPassword = "Noura124";
    }

    @Test(priority = 10, groups = {"BAT"}, enabled = false)
    public void testAddItemToCart() throws InterruptedException {
        // Test Case 3: Add Item to Cart (Verify that an item can be added to the cart)

        testSearchBar();

        Homepage homepage = new Homepage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        // Steps to add an item to the cart
        homepage.searchForItem("legging");
        productPage.addItemToCart();

        // Assertion for the added item
        Assert.assertTrue(cartPage.isCartItemDisplayed());
    }

    @Test(priority = 11, groups = {"BAT"}, enabled = false)
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