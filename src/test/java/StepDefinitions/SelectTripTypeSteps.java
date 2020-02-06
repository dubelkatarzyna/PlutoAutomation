package StepDefinitions;

import Base.BaseUtil;
import Pages.QuoteTypePage;
import Pages.SingleTripTypePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectTripTypeSteps extends BaseUtil {

    private BaseUtil base;
    WebDriverWait wait = new WebDriverWait(base.Driver, 5);
    QuoteTypePage quoteTypePage = new QuoteTypePage(base.Driver);
    SingleTripTypePage singleTripTypePage = new SingleTripTypePage(base.Driver);

    public SelectTripTypeSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^a web browser is at the quote types page$")
    public void aWebBrowserIsAtTheQuoteTypesPage() {
        base.Driver.navigate().to("https://pluto-customer-web-app-staging.herokuapp.com/tailored-annual-or-single");
        Assert.assertEquals("Pluto | Travel cover", base.Driver.getTitle());
    }

    @When("^a user selects single trip quote$")
    public void aUserSelectsSingleTripQuote() {
        quoteTypePage.selectSingleTripCover();
    }

    @Then("^trip details page is opened$")
    public void tripDetailsPageIsOpened() {
        Assert.assertTrue(base.Driver.getPageSource().contains("Some details about your trip"));
    }

    @When("^a user provides details about the trip$")
    public void aUserProvidesDetailsAboutTheTrip() {
        singleTripTypePage.typeCountry();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/div/div/div/div[2]/div/button")));
    }

    @And("^clicks on Next$")
    public void clicksOnNext() {
        singleTripTypePage.nextButtonClick();
    }

    @Then("^annual cover details page is opened$")
    public void annualCoverDetailsPageIsOpened() {
        Assert.assertTrue(base.Driver.getPageSource().contains("Where do you need cover for?"));
    }

    @When("^a user selects annual cover quote$")
    public void aUserSelectsAnnualCoverQuote() {
        quoteTypePage.selectAnnualCover();
    }
}
