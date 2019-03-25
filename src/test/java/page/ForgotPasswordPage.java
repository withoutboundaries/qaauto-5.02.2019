package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailfield;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return emailfield.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset?trk=uno-reg-guest-home-forgot-password");
        //&& driver.getTitle().contains();
    }

    public ResendLinkPage input(String email) {
        emailfield.sendKeys(email);
        emailfield.sendKeys(Keys.ENTER);
        return new ResendLinkPage(driver);
    }
}
