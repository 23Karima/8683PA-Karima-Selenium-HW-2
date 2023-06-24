package app.pom.search;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {
    private By searchResults = By.xpath("//a[@class='product-item-link']");
    private By searchResultItem = By.xpath("//a[@class='product-item-link']");

    public boolean areSearchResultsDisplayed() {
        // Implementation to check if search results are displayed
        WebElement resultsElement = driver.findElement(searchResults);
        return resultsElement.isDisplayed();
    }

    public boolean isSearchTermHighlighted(String searchTerm) {
        // Implementation to check if search term is highlighted in the results
        By searchTermHighlight = By.xpath("//div[@class='search-results']//*[contains(text(),'" + searchTerm + "')]");
        WebElement highlightElement = driver.findElement(searchTermHighlight);
        return highlightElement.isDisplayed();
    }

    public void clickFirstSearchResult() {
        // Implementation for clicking the first search result
        WebElement firstResult = driver.findElement(searchResultItem);
        firstResult.click();
    }
}