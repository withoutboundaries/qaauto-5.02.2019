package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPasswordPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailfield;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return emailfield.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset?trk=uno-reg-guest-home-forgot-password");
        //&& driver.getTitle().contains();
    }

    public ResendLinkPage input(String email) {
        emailfield.sendKeys(email);

        String messageSubject = "here's the link to reset your password";
        String messageTo = email;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();
        emailfield.sendKeys(Keys.ENTER);

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        return new ResendLinkPage(driver, message);
    }

    }


