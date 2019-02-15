import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class LoginTests {

    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnatyshko_i\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

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
        meIcon.click();
    }


}

