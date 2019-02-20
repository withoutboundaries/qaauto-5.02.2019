
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
                { "petrenkovira19890206@gmail.com", "love19890206love"},
                { "PetrenkoVira19890206@gmail.com", "love19890206love"},
                { " petrenkovira19890206@gmail.com ", "love19890206love"},
        };
    }

    @Test(dataProvider = "ValidData")
    public void successfulLoginTest(String userEmail, String userPassword) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded (), "Landing page is not loaded");
        landingPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),"Home page is loaded");
    }

    @Test
    public void negativeLoginTest () {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("petrenkovira19890206@gmail.com", "123456");

        LoginSubmit loginSubmit = new LoginSubmit(driver);

        Assert.assertTrue(loginSubmit.isPasswordErrorMessageBlockDisplayed(),
                "passwordErrorMessageBlock is not displayed on Home page");
        Assert.assertEquals(loginSubmit.passwordErrorMessageBlock.getText(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Wrong validation message text for 'password' field.");
    }

}




