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
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login("petrenkovira19890206@gmail.com", "love19890206love");


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
    public void negativeLoginTestHomeWork() {
        //HomeWork #4

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        /*TC #1. Leave blank userEmailField and fill in correct userPasswordField. Click on signInButton.
         Expected:Please enter an email address or phone number */
        userPasswordField.sendKeys("love19890206love");
        signInButton.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement alert1 = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String alertText1 = alert1.getText();
        //Assert.assertTrue(alertText1);
        System.out.println(alertText1);

        /*TC #2. Fill in incorrect userEmailField but correct userPasswordField. Click on signInButton
        Expected:Hmm, we don't recognize that email. Please try again.*/
        userEmailField.sendKeys("petrenkovira198902061@gmail.com");
        userPasswordField.sendKeys("love19890206love");
        signInButton.click();

        WebElement alert2 = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String alertText2 = alert2.getText();
        WebElement profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        profileMenuItem.isDisplayed();

        Assert.assertFalse(profileMenuItem.isDisplayed(),
                "userEmailField is incorrect");

        /*TC #3. Fill correct password in userEmailField and correct login in userPasswordField. Click on signInButton
        Expected: Please enter a valid username */
        userEmailField.sendKeys("love19890206love");
        userPasswordField.sendKeys("petrenkovira19890206@gmail.com");
        signInButton.click();

        WebElement alert3 = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String alertText3 = alert3.getText();
        //Assert.assertTrue(alertText3);
        System.out.println(alertText3);

        /*TC #4. Fill special symbols like '$%@&' in userEmailField but correct userPasswordField. Click on signInButton
        Expected: Be sure to include "+" and your country code. */
        userEmailField.sendKeys("$%@&");
        userPasswordField.sendKeys("love19890206love");
        signInButton.click();

        WebElement alert4 = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        String alertText4 = alert4.getText();
        //Assert.assertTrue(alertText4);
        System.out.println(alertText4);

        /*TC #5.Fill 'asdfghjklzxcvbrtnfutndlsfgerwvjd' in userEmailField and correct userPasswordField. Click on signInButton
        Expected: message like 'such user does not exist' but it enables to go to SecurityVerificationTab: https://www.linkedin.com/checkpoint/challenge/AQFIRqi8W3pRWgAAAWkD693kPOCTnIjQ8chZ1V5oJTcDbcNfUq0KGvlIfFql8ooc6MohLgOXuP-sEVXlmmzuryWigIXixw?ut=2SDiFmlSMPkUE1
        and only after operations with "Verify I'm not a robot" we receive the message 'Please enter a valid email address.'*/
        userEmailField.sendKeys("asdfghjklzxcvbrtnfutndlsfgerwvjd");
        userPasswordField.sendKeys("love19890206love");
        signInButton.click();

    }

    @Test
    public void negativeLoginTest() {
        //Classwork #5
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        userEmailField.sendKeys("petrenkovira19890206@gmail.com");
        userPasswordField.sendKeys("123456");
        signInButton.click();

        WebElement passwordErrorMessageBlock = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        Assert.assertTrue(passwordErrorMessageBlock.isDisplayed(),
                "passwordErrorMessageBlock is not displayed on Home page");

        Assert.assertEquals(passwordErrorMessageBlock.getText(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Wrong validation message text for 'password' field.");


    }


}

