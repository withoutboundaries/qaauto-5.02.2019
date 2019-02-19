import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    WebElement profileMenuItem;

    public HomePage (WebDriver driver){
        this.driver = driver;
        initElement ();
    }

    public  void initElement() {
        profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
    }

    public boolean isProfileNavMenuItemDisplayed (){
        return profileMenuItem.isDisplayed();
    }

}
