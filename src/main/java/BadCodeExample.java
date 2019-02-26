
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;


public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnatyshko_i\\IdeaProjects\\qaauto-5.02.2019\\chromedriver.exe");
        WebDriver driver;
        driver= new ChromeDriver();
        driver.get("https://www.google.com/");

        /* My HomeWork
        1st variant
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium");
        element.submit();*/

        /* My HomeWork
        2nd variant
        System.out.println("Selenium");
        driver.get("https://www.google.com/search?q=Selenium&rlz=1C1OKWM_ukUA835UA835&oq=Selenium&aqs=chrome..69i57j0l5.3475j0j8&sourceid=chrome&ie=UTF-8");
*/

        //3rd variant - ClassWork
        String searchTerm="Selenium";
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='g']"));
        System.out.println("Results count:" + searchResultElements.size());


      /* My HomeWork
        List<WebElement> allelements = driver.findElements(By.xpath("//div[@class='g']"));
        Iterator<WebElement> itr = allelements.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next().getText());
        }

        if(driver.findElement(By.xpath("//div[@class='g']")).getText().toLowerCase().contains("selenium".toLowerCase()))
        {
            System.out.println("searchTerm found");
        }

        else
        {
            System.out.println("searchTerm not found");
        }
*/
        //ClassWork: For each WebElement in searchResultElements print text
        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();
            System.out.println(searchResultElementText);
            if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("searchTerm found");
            } else {
                System.out.println("searchTerm not found");
            }
        }
    }
}
