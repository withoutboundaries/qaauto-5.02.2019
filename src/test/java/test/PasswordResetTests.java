package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;


public class PasswordResetTests extends BaseTest {
    @Test

    public void successfulPasswordResetTest() {

        String email = "petrenkovira19890206@gmail.com";
        String link = "https://www.linkedin.com/e/v2?e=bual58-jtogcseu-vq&lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BLoSIGmkFTzyBdwKyOqlcsw%3D%3D&a=checkpoint-password-reset&midToken=AQGtkiMu7W8DWA&tracking=eml-jav-saved-job&ek=security_password_reset_checkpoint&encryptedEmail=AgFmEk9QZM69AwAAAWm1Rhq_8qa_LDLHJI0N-RlZCTr2APIyaXs9BYsikp7JiZyD0S7PhaiAn_s3r60r52EmuA&requestSubmissionId=AgHdt4nTdiujegAAAWm1RhrIY5zBzFWJ5SlNy_K9FZVqCYICKiQ_Oq-_SUyi7J82u1xogUra2YAltp3B9hsZNlJxRY6DfRT7OoZSzYiYx_Y&oneTimeToken=-725034495336784533&_sig=1ns45pf8bG58I1";
        String newPasswordFieldText = "love19850526love";
        String retypeNewPasswordFieldText = "love19850526love";

        //1
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded");

        //2
        ForgotPasswordPage forgotPasswordPage = landingPage.clickforgotpassword();
        Assert.assertTrue(forgotPasswordPage.isPageLoaded(), "ForgotPassword page is not loaded");

        //3
        ResendLinkPage resendLinkPage = forgotPasswordPage.input(email);
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(resendLinkPage.isPageLoaded(), "ResendLink page is not loaded");

        //4
        ResetPasswordPage resetPasswordPage = resendLinkPage.resetPasswordUrl("https://www.linkedin.com/e/v2?e=bual58-jtogpdwi-81&lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BQQgjLL5%2BRk2pCRZd67JTAg%3D%3D&a=checkpoint-password-reset&midToken=AQGtkiMu7W8DWA&tracking=eml-jav-saved-job&ek=security_password_reset_checkpoint&encryptedEmail=AgF5H0_BKoj_QAAAAWm1TxKN2zG2mMzOajWiit29oACyYZK3qMrCQP_3jItNBDqCOMy1N-82IH6ksMgLu8REWg&requestSubmissionId=AgHB5zw4jNTDegAAAWm1TxKWL_bzYWvdzl2x7GeP0X-Jge4-eBkgRgH9dOX4XKF-XB0w4xl3PlHOWdFAdS1jvJTj2STLk4A6wcPnpTYnZSQ&oneTimeToken=-725034495336784533&_sig=25THTfbDvQ58I1");
        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "Reset Password page is not loaded");

        //5
        PasswordResetSubmitPage passwordResetSubmitPage = resetPasswordPage.successfulResetPassword(newPasswordFieldText, retypeNewPasswordFieldText);
        Assert.assertTrue(passwordResetSubmitPage.isPageLoaded(), "Password Reset Submit page is not loaded");

        //6
        HomePage homePage = passwordResetSubmitPage.goToHomePage();
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");
    }

}

