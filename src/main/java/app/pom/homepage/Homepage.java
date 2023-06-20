package app.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage extends BasePage {//here this class extends BasePage class .
    // contain a logo named WebElement that is annotations with @FindBy
    @FindBy (xpath = "//a[@href='https://magento.softwaretestingboard.com/']")//locate an element on the webpage using an XPath expression.
    public WebElement logo;

    public Homepage(){
        PageFactory.initElements(driver, this);// initialize the element on the page
    }

}
