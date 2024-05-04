package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage{
    public String password ="123456aa";
    public String phoneNumber = "12096194991";
    public String Email = "xagopot780@deligy.com";
    public By emailInputBox = By.xpath("//input[@data-qa='login-email']");
    public By passwordInputBox = By.xpath("//input[@placeholder='Password']");
    public By logInButton = By.xpath("//button[normalize-space()='Login']");
    public By errorMsg = By.xpath("//input[@name='password']/following-sibling::p");

}
