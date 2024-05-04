package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import utilities.BrowserSetup;
import utilities.DataSet;

public class TestLogin extends BrowserSetup {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    @BeforeMethod
    public void loadSignInPage(){
        getBrowser().get(homePage.url);
        homePage.clickOnElement(homePage.signInButton);
    }

    @Test
    public void testLoginWithValidCredentials(){
        signInPage.writeOnElement(signInPage.emailInputBox, "xagopot780@deligy.com");
        signInPage.writeOnElement(signInPage.passwordInputBox, "123456aa");
        signInPage.clickOnElement(signInPage.logInButton);
        Assert.assertTrue(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithInvalidPassword(){
        signInPage.writeOnElement(signInPage.emailInputBox, "xagopot780@deligy.com");
        signInPage.writeOnElement(signInPage.passwordInputBox, "123456");
        signInPage.clickOnElement(signInPage.logInButton);
        Assert.assertEquals(signInPage.getElement(signInPage.errorMsg).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }
    @Test
    public void testLoginWithInvalidEmail(){
        signInPage.writeOnElement(signInPage.emailInputBox, "xagopot780@");
        signInPage.writeOnElement(signInPage.passwordInputBox, "123456aa");
        signInPage.clickOnElement(signInPage.logInButton);
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithoutPassword(){
        signInPage.writeOnElement(signInPage.emailInputBox, "xagopot780@deligy.com");
        signInPage.clickOnElement(signInPage.logInButton);
//        Assert.assertEquals(signInPage.getElement(signInPage.errorMsg).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithoutEmail(){
        signInPage.writeOnElement(signInPage.passwordInputBox, "123456aa");
        signInPage.clickOnElement(signInPage.logInButton);
//        Assert.assertEquals(signInPage.getElement(signInPage.errorMsg).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginWithoutEmailAndPassword(){
        signInPage.clickOnElement(signInPage.logInButton);
//        Assert.assertEquals(signInPage.getElement(signInPage.errorMsg).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test
    public void testLoginInvalidEmailAndPassword(){
        signInPage.writeOnElement(signInPage.emailInputBox, "xagopot780@deligy.co");
        signInPage.writeOnElement(signInPage.passwordInputBox, "123456a");
        signInPage.clickOnElement(signInPage.logInButton);
        Assert.assertEquals(signInPage.getElement(signInPage.errorMsg).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithInvalidCredentials(String username, String password, String errorMag){

        signInPage.writeOnElement(signInPage.emailInputBox, username);
        signInPage.writeOnElement(signInPage.passwordInputBox, password);
        signInPage.clickOnElement(signInPage.logInButton);
//        Assert.assertEquals(signInPage.getElement(signInPage.errorMsg).getText(), errorMag);
        Assert.assertFalse(homePage.displayStatus(homePage.logoutButton));
    }
}
