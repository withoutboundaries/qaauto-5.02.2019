package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetSubmitPage extends BasePage {

    private WebDriver driver;


    @FindBy (xpath ="//button[@id='reset-password-submit-button']")
    private WebElement goToHomePageButton;

    public PasswordResetSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return goToHomePageButton.isDisplayed()
                && driver.getCurrentUrl().contains("/password-reset-submit");
        //&& driver.getTitle().contains();
    }

    public HomePage goToHomePage() {
        goToHomePageButton.click();
        return new HomePage(driver);
    }
}
