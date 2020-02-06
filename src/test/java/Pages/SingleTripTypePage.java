package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SingleTripTypePage {

    private WebDriver driver;

    public SingleTripTypePage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeTripStartDate() {
        driver.findElement(By.cssSelector("#start-date")).sendKeys("02/08/2020");
    }

    public void typeTripEndDate() {
        driver.findElement(By.cssSelector("#end-date")).sendKeys("20/08/2020");
    }

    public void typeCountry() {
        driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys("France" + Keys.RETURN);
    }

    public void addAnotherDesinationClick() {
        driver.findElement(By.cssSelector("#root > div > div > div.jss368.root-container > main > div > div > div > div > div:nth-child(1) > div > fieldset > button > span")).click();
    }

    public void nextButtonClick() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/div/div/div/div[2]/div/button")).click();
    }

}
