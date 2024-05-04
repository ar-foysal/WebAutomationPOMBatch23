package testcases.GoZayeen;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GoZayen.HomePageGZ;
import pages.GoZayen.SignInPageGZ;
import utilities.BrowserSetup;

public class TestGoZayeenLogin extends BrowserSetup {
    HomePageGZ homePage = new HomePageGZ();
    SignInPageGZ signInPage = new SignInPageGZ();

    @Test
    public void testLogin(){
        getBrowser().get(homePage.url);
        homePage.clickOnElement(homePage.signInButton);
        signInPage.writeOnElement(signInPage.emailInputBox, signInPage.Email);
        signInPage.writeOnElement(signInPage.passwordInputBox, signInPage.password);
        signInPage.clickOnElement(signInPage.logInButton);
        Assert.assertTrue(homePage.displayStatus(homePage.userIcon));
    }
}
