package Login;

import Utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest {

    @Test
    public void FailedLogin() throws IOException, InterruptedException {

        Utility.openFirefox("https://application.adthena.com/");
        Utility.enterText(Login.userField,TestData.user);
        Utility.enterText(Login.passwordField,TestData.incorrectPass);
        Utility.clickElement(Login.loginButton);
        Assert.assertEquals(Utility.findElement(Login.passwordErrorMessageLocation).getText(),Login.passwordErrorMessage);
        Thread.sleep(500l);
        Utility.takeScreenshot("FailedLogin");
        Utility.quitFirefox();
    }

    @Test
    public void SuccessfulLogin() throws IOException, InterruptedException {

        Utility.openFirefox("https://application.adthena.com/");

        //using mandroid credentials
        Utility.enterText(Login.userField,TestData.user);
        Utility.enterText(Login.passwordField,TestData.correctPass);
        Utility.clickElement(Login.loginButton);
        Thread.sleep(5000l);
        Assert.assertEquals(Utility.findElement("[class='page-header clearfix']").getText(),"Summary Dashboard");
        Utility.takeScreenshot("SuccessfulLogin");
        Utility.quitFirefox();
    }
}