

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

    @FindBy(xpath = "//div [@class='search-result__info pt3 pb4 ph0']")
    private WebElement resultElement;

    @FindBy(xpath = "//div [@class='search-result__info pt3 pb4 ph0']")
    List<WebElement> resultElements;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("search/results")
                && driver.getTitle().contains("| Search | LinkedIn");
    }

    public int getSearchResultCount() {
        return resultElements.size();
    }


    public List<String> getSearchResultsList() {
        List<String> resultsTextList = new ArrayList<String>();
        for (WebElement resultElement : resultElements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", resultElement);
            resultsTextList.add(resultElement.getText());
        }
        return resultsTextList;
    }








}



