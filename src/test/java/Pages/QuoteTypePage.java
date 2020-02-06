package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuoteTypePage {

    private WebDriver driver;

    public QuoteTypePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAnnualCover() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/div/div/div/div/div[1]/div[1]/div/button/span")).click();
    }

    public void selectSingleTripCover() {
        driver.findElement(By.cssSelector("#root > div > div > div.jss368.root-container > main > div > div > div > div > div > div:nth-child(1) > div:nth-child(3) > div > button")).click();
    }

    public void addReferralCodeClick() {
        driver.findElement(By.cssSelector("#root > div > div > div.jss368.root-container > main > div > div > div > div > div > div:nth-child(2) > div > h4")).click();
    }

    public void typeReferralCode() {
        driver.findElement(By.cssSelector("#discount")).sendKeys("code");
    }
}
