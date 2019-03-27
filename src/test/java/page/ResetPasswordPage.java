package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage {

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement retypeNewPasswordField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return retypeNewPasswordField.isDisplayed()
                && driver.getCurrentUrl().contains("/password-reset");
              //  && driver.getTitle().contains("Reset Your Password | LinkedIn");

    }

    public PasswordResetSubmitPage successfulResetPassword(String newPasswordFieldText, String retypeNewPasswordFieldText) {
        newPasswordField.sendKeys(newPasswordFieldText);
        retypeNewPasswordField.sendKeys(retypeNewPasswordFieldText);
        submitButton.click();
        return new PasswordResetSubmitPage(driver);
    }
}
