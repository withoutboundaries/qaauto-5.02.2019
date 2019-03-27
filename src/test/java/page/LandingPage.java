package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;


/**
 * Class that describes LandingPage pageObject.
 */
public class LandingPage extends BasePage {

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordField;

    /**
     * Constructor of LandingPage class.
     * @param driver Browser object from Test
     */
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.getCurrentUrl().contains("/feed")) {
            return (T) new HomePage(driver);
        } else {
            return (T) new LoginSubmitPage(driver);
        }
    }

    public <ExpectedPage> ExpectedPage login (String userEmail, String userPassword, Class <ExpectedPage> expectedPage) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return PageFactory.initElements(driver, expectedPage);
    }


    public Object login2(String userEmail, String userPassword, int source) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        if (source == 1) {
            return new HomePage(driver);
        } else {
            return new LoginSubmitPage(driver);
        }
    }

    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }

    public ForgotPasswordPage clickforgotpassword () {
        forgotPasswordField.click();
        return new ForgotPasswordPage (driver);
    }
}
