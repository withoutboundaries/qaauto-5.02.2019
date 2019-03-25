package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement resultsTotal;


    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("search/results")
                && driver.getTitle().contains("| Search | LinkedIn");
    }


    public int getSearchResultCount() {
        return searchResults.size();
    }

/*
    public List<String> getSearchResultsList() {
        List<String> resultsTextList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            resultsTextList.add(searchResult.getText());
        }
        return resultsTextList;
    }
    */

    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            searchResultsList.add(searchResult.getText());
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultsList.add(searchResult.getText());
        }
        return searchResultsList;
    }
}





