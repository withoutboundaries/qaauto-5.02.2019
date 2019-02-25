
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnatyshko_i\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @DataProvider
    public Object[][] ValidData() {
        return new Object[][]{
                {"petrenkovira19890206@gmail.com", "love19890206love"},
                {"PetrenkoVira19890206@gmail.com", "love19890206love"},
                {" petrenkovira19890206@gmail.com ", "love19890206love"},
        };
    }

    @Test(dataProvider = "ValidData")
    public void successfulLoginTest(String userEmail, String userPassword) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        landingPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is loaded");
    }

    @DataProvider
    public Object[][] InValidData() {
        return new Object[][]{
                {"", "love19890206love", "Please enter an email address or phone number", ""},
                {"petrenkovira198902061@gmail.com", "love19890206love", "Hmm, we don't recognize that email. Please try again.", ""},
                {"love19890206love", "petrenkovira19890206@gmail.com", "Please enter a valid username", ""},
                {"$%@&", "love19890206love", "Be sure to include "+" and your country code.", ""},
                {"asdfghjklzxcvbrtnfutndlsfgerwvjd", "love19890206love", "Please enter a valid username", ""},
                {"petrenkovira19890206@gmail.com", "love19890206lo", "", "Hmm, that's not the right password. Please try again or request a new one."},

        };
    }


    @Test(dataProvider = "InValidData")
    public void negativeLoginTest(String userEmail, String userPassword, String emailValidationMessage, String passwordValidationMessage) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(userEmail, userPassword);

        LoginSubmit loginSubmit = new LoginSubmit(driver);

        Assert.assertTrue(loginSubmit.isPasswordErrorMessageBlockDisplayed(),
                "passwordErrorMessageBlock is not displayed on Home page");
        Assert.assertEquals(loginSubmit.passwordErrorMessageBlock.getText(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Wrong validation message text for 'password' field.");
    }

}




