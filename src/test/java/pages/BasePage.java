package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.BrowserSetup.getBrowser;

public class BasePage {

    public WebElement getElement(By locator){
        return getBrowser().findElement(locator);
    }

    public void writeOnElement(By locator, String text ){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public Boolean displayStatus(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public Alert getAlert(){
        WebDriverWait wait = new WebDriverWait(getBrowser(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
