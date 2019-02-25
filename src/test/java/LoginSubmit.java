import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSubmit {
    WebDriver driver;

    WebElement passwordErrorMessageBlock;
    String emailValidationMessage;
    String passwordValidationMessage;

    public LoginSubmit(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
       passwordErrorMessageBlock = driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public boolean isPasswordErrorMessageBlockDisplayed () {
        return passwordErrorMessageBlock.isDisplayed();
    }


}



