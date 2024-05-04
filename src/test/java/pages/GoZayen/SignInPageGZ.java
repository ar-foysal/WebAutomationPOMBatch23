package pages.GoZayen;

import org.openqa.selenium.By;
import pages.BasePage;

public class SignInPageGZ extends BasePage {
    public String password ="12AsA#219";
    public String phoneNumber = "12096194991";
    public String Email = "xagopot780@deligy.com";
    public By emailInputBox = By.id("email");
    public By passwordInputBox = By.id("password");
    public By logInButton = By.id("submitBtn");
    public By ErrorMsg = By.id("div[class='text-danger']");

}
