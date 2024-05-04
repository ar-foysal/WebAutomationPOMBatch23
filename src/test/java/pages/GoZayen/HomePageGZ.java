package pages.GoZayen;

import org.openqa.selenium.By;
import pages.BasePage;

public class HomePageGZ extends BasePage {
    public String url = "https://gozayaan.com/";

    public By signInButton = By.xpath("//div[@class=\"auth-action\"]/button");
    public By userIcon = By.id("#__BVID__234__BV_toggle_");

}
