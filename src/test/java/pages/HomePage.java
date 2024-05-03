package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String url = "https://gozayaan.com/";

    public By signInButton = By.xpath("//div[@class=\"auth-action\"]/button");
    public By userIcon = By.id("#__BVID__234__BV_toggle_");

}
