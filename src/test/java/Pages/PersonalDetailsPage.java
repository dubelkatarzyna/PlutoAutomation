package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPage {

    private WebDriver driver;

    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUsername() {
        driver.findElement(By.cssSelector("#username")).sendKeys("name surname");
    }

    public void usernameTextboxClick() {
        driver.findElement(By.cssSelector("#username")).click();
    }

    public void typeAge(String age) {
        driver.findElement(By.cssSelector("#age")).sendKeys(age);
    }

    public void selectPreExistingMedicalPreconditions() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/div/div/div/div/div[2]/div[1]/div/fieldset/div/label[2]/span[1]/span")).click();
    }

    public void selectNoPreExistingMedicalConditions() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/div/div/div/div/div[2]/div[1]/div/fieldset/div/label[1]/span[1]")).click();
    }

    public void nextButtonClick() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/div/div/div/div/div[2]/div[2]/button/span")).click();
    }
}
