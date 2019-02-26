import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginSubmit {
    private WebDriver driver;

    @FindBy(xpath ="//form[@class='login__form']")
    private WebElement loginForm;

    @FindBy(xpath ="//div[@id='error-for-username']")
    WebElement userEmailValidationMessage;

    @FindBy(xpath ="//div[@id='error-for-password']")
    WebElement userPasswordValidationMessage;;

    public LoginSubmit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return loginForm.isDisplayed()
                && driver.getCurrentUrl().contains("/login-submit")
                && driver.getTitle().contains("LinkedIn");
    }

    public String getUserEmailValidationText() {
        return userEmailValidationMessage.getText();
    }

    public String getUserPasswordValidationText() {
        return userPasswordValidationMessage.getText();
    }



}
