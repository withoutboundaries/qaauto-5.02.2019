package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ResendLinkPage{
    private WebDriver driver;
    private String message;

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkfield;



    public ResendLinkPage(WebDriver driver,String message) {
        this.driver = driver;
        this.message= message;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resendLinkfield.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset-submit");
               // && driver.getTitle().contains();
    }

    public String extractUrls()
    {

        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((\\/\\/)|(\\\\))+[\\w\\d:#@%\\/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(this.message);

        while (urlMatcher.find())
        {
            containedUrls.add(this.message.substring(urlMatcher.start(0), urlMatcher.end(0)));
        }

        for (String str: containedUrls) {


            if (str.contains("sig="))

                return str.replace("amp;","");
            }

        return "";

    }


    public ResetPasswordPage resetPasswordUrl() {
        String link = this.extractUrls();
        driver.get(link);
        return new ResetPasswordPage(driver);
    }


}
