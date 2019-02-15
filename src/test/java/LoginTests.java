import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class LoginTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnatyshko_i\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod () {
        driver.quit();
    }


    @Test
    public void successfulLoginTest() {


        /*MyHomeWork #3
        String userEmailField = "petrenkovira19890206@gmail.com";
        String userPasswordField = "love19890206love";
        WebElement signIn = driver.findElement(By.id("login-submit"));

        //1
        WebElement loginEmailField = driver.findElement(By.id("login-email"));
        loginEmailField.sendKeys(userEmailField);
        //2
        WebElement loginPasswordField = driver.findElement(By.id("login-password"));
        loginPasswordField.sendKeys(userPasswordField);
        //3
        signIn.click();
        //4
        WebElement meIcon = driver.findElement(By.xpath("//div[@class='nav-item__profile-member-photo nav-item__icon ghost-person']"));
        meIcon.click()
        ;
        */

        //ClassWork
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("petrenkovira19890206@gmail.com");
        userPasswordField.sendKeys("love19890206love");
        signInButton.click();

        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        profileMenuItem.isDisplayed();
        Assert.assertTrue(profileMenuItem.isDisplayed());
      /*Assert.assertFalse(profileMenuItem.isDisplayed(),
              "profileMenuItem is not displayed on Home page.");
              */
        Assert.assertEquals(
                /*Actual*/ driver.getCurrentUrl(),
                /*Expected*/"https://www.linkedin.com/feed/",
                "Home page URL is incorrect");
    }

    @Test
    public void negativeLoginTest() {
    }

    @Test
    public void positiveLoginTest() {
    }
}

