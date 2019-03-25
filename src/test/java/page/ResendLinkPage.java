package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResendLinkPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkfield;


    public ResendLinkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resendLinkfield.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset-submit");
               // && driver.getTitle().contains();
    }

    public ResetPasswordPage resetPasswordUrl(String link) {
        try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(link);
        return new ResetPasswordPage(driver);
    }


}
