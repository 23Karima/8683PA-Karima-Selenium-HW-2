package app.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {
    // Define WebElement for the logo using @FindBy annotation with XPath expression
    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/']")
    public WebElement logo;

    // Define WebElement for the search bar using @FindBy annotation with id
    @FindBy(xpath = "//input[@id = 'search']")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@title='Search']")
    public WebElement searchBtn;


    public Homepage() {
        PageFactory.initElements(driver, this);
        // Initialize the elements on the page using PageFactory.initElements()
    }

    public void searchForItem(String item) {// Method for searching for an item
        searchBar.sendKeys(item);
        // Enter the search item into the search bar
    }
}