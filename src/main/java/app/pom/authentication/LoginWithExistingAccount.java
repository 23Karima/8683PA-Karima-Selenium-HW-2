package app.pom.authentication;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithExistingAccount extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'alert')]")
    public WebElement resultLoginMessage;

    public LoginWithExistingAccount() {
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        sendKeysToElement(emailField, email);
        sendKeysToElement(passwordField, password);
        safeClickOnElement(loginButton);
    }
}