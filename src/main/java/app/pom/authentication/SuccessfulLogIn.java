package app.pom.authentication;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulLogIn extends BasePage {
    @FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']")
    public WebElement welcomeTextMessage;

    public SuccessfulLogIn() {
        super(); // Call the constructor of the BasePage class
        PageFactory.initElements(driver, this);
    }
}