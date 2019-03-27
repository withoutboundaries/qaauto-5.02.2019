package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;


public class PasswordResetTests extends BaseTest {
    @Test

    public void successfulPasswordResetTest() {

        String email = "petrenkovira19890206@gmail.com";
        String newPasswordFieldText = "love19850526love";
        String retypeNewPasswordFieldText = "love19850526love";

        //1
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        //2
        ForgotPasswordPage forgotPasswordPage = landingPage.clickforgotpassword();
        Assert.assertTrue(forgotPasswordPage.isPageLoaded(), "Forgot Password page is not loaded");

        //3
        ResendLinkPage resendLinkPage = forgotPasswordPage.input(email);
        Assert.assertTrue(resendLinkPage.isPageLoaded(), "Resend Link page is not loaded");

        //4
        ResetPasswordPage resetPasswordPage = resendLinkPage.getresetPasswordUrl();
        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "Reset Password page is not loaded");


        //5
        PasswordResetSubmitPage passwordResetSubmitPage = resetPasswordPage.successfulResetPassword(newPasswordFieldText, retypeNewPasswordFieldText);
        Assert.assertTrue(passwordResetSubmitPage.isPageLoaded(), "Password Reset Submit page is not loaded");

        //6
        HomePage homePage = passwordResetSubmitPage.goToHomePage();
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");


    }


}

