package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PolicyDetailsPage {

    private WebDriver driver;

    public PolicyDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void emailYourQuoteHyperlinkClick() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/div/div/div[2]/div/div[3]/div/div[2]/a")).click();
    }
}
