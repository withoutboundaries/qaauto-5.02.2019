import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSubmit {
    WebDriver driver;

    WebElement userEmailFieldLoginSubmit;
    WebElement userPasswordFieldLoginSubmit;
    WebElement signInButtonLoginSubmit;
    WebElement passwordErrorMessageBlock;

    public LoginSubmit(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        userEmailFieldLoginSubmit = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordFieldLoginSubmit = driver.findElement(By.xpath("//input[@id='login-password']"));
        signInButtonLoginSubmit = driver.findElement(By.xpath("//input[@id='login-submit']"));
        passwordErrorMessageBlock = driver.findElement(By.xpath("//div[@id='error-for-password']"));

    }
public void submit (String userField, String userPassword) {
    userEmailFieldLoginSubmit.sendKeys("petrenkovira19890206@gmail.com");
    userPasswordFieldLoginSubmit.sendKeys("123456");
    signInButtonLoginSubmit.click();
}

    public boolean isPasswordErrorMessageBlockDisplayed () {
        return passwordErrorMessageBlock.isDisplayed();
    }
     public boolean getPasswordErrorMessageBlockText(){
             return super.equals( passwordErrorMessageBlock.getText());
         }

}



