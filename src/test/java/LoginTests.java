import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

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

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        HomePage homePage = landingPage.login(userEmail, userPassword, HomePage.class);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");
    }

    @DataProvider
    public Object[][] InValidData() {
        return new Object[][]{
                {"petrenkovira198902061@gmail.com", "love19890206love", "Hmm, we don't recognize that email. Please try again.", ""},
                {"love19890206love", "petrenkovira19890206@gmail.com", "Please enter a valid email address.", ""},
                {"$%@&", "love19890206love", "Be sure to include \"+\" and your country code.", ""},
                {"asdfghjklzxcvbrtnfutndlsfgerwvjd", "love19890206love", "Please enter a valid email address.", ""},
                {"petrenkovira19890206@gmail.com", "love19890206lo", "", "Hmm, that's not the right password. Please try again or request a new one."},

        };
    }

    @Test(dataProvider = "InValidData")
    public void negativeLoginTest(String userEmail,
                                  String userPassword,
                                  String emailValidationMessage,
                                  String passwordValidationMessage) {

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");
        LoginSubmit loginSubmit = landingPage.login (userEmail, userPassword);

        Assert.assertTrue(loginSubmit.isPageLoaded(),
                "LoginSubmit is not loaded");


        Assert.assertEquals(loginSubmit.getUserEmailValidationText(), emailValidationMessage,
                "userEmail validation message text is wrong");

        Assert.assertEquals(loginSubmit.getUserPasswordValidationText(), passwordValidationMessage,
                "userPassword validation message text is wrong");
    }

}




