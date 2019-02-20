import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

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


    @Test
    public void successfulLoginTest() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("petrenkovira19890206@gmail.com", "love19890206love");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProfileNavMenuItemDisplayed(),
                "Home page URL is incorrect");
    }

    @Test
    public void negativeLoginTest () {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("petrenkovira19890206@gmail.com", "12345");

        LoginSubmit loginSubmit = new LoginSubmit(driver);
        loginSubmit.submit("petrenkovira19890206@gmail.com", "123456");
        Assert.assertTrue(loginSubmit.isPasswordErrorMessageBlockDisplayed(),
                "passwordErrorMessageBlock is not displayed on Home page");
        Assert.assertEquals(loginSubmit.getPasswordErrorMessageBlockText(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Wrong validation message text for 'password' field.");
    }

}




