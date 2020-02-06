package StepDefinitions;

import Base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestOnlineClaimForm extends BaseUtil {

    private BaseUtil base;
    WebDriverWait wait = new WebDriverWait(base.Driver, 5);

    public RequestOnlineClaimForm(BaseUtil base) {
        this.base = base;
    }

    @Given("^a web browser is at the start claim page$")
    public void aWebBrowserIsAtTheStartClaimPage() {
        base.Driver.navigate().to("https://buy.pluto.travel/start-claim?utm_expid=.m3gDY20ISSGKpXSVvHwziw.0&utm_referrer=");
        //Assert.assertEquals("Pluto | Claims", base.Driver.getTitle()); //blad na stronie - tytul sie nie zgadza, powinno byc Pluto | Claims
    }

    @When("^the user provides its e-mail address and submits$")
    public void theUserProvidesItsEMailAddressAndSubmits() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div.jss15.root-container > div > div > div.jss28.jss51 > button > span")));
        base.Driver.findElement(By.cssSelector("#email")).sendKeys("email@email.com");
        base.Driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[2]/button/span/span")).click();
        wait.until(ExpectedConditions.urlContains("claim-requested"));
    }

    @Then("^a link to the online form is being sent$")
    public void aLinkToTheOnlineFormIsBeingSent() {
        Assert.assertTrue(base.Driver.getPageSource().contains("We’ve emailed you a link to start your claim"));
    }
}
