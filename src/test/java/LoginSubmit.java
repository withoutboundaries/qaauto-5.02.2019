import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSubmit {
    private WebDriver driver;
    private WebElement loginForm;
    WebElement userEmailValidationMessage;
    WebElement userPasswordValidationMessage;;

    public LoginSubmit(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        loginForm=driver.findElement(By.xpath("//form[@class='login__form']"));
        userEmailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        userPasswordValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
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
