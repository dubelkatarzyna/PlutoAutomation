package StepDefinitions;

import Base.BaseUtil;
import Pages.PersonalDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetailsSteps extends BaseUtil {

    private BaseUtil base;
    WebDriverWait wait = new WebDriverWait(base.Driver, 5);
    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(base.Driver);

    public PersonalDetailsSteps(BaseUtil base) {
        this.base = base;
    }

    @Then("^personal details page is opened$")
    public void personalDetailsPageIsOpened() {
        Assert.assertTrue(base.Driver.getPageSource().contains("A bit about you"));
    }

    @When("^a user provides details$")
    public void aUserProvidesDetailsAndSubmits() {
        personalDetailsPage.typeUsername();
        personalDetailsPage.typeAge("25");
        personalDetailsPage.selectPreExistingMedicalPreconditions();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[1]/main/div/div/div/div/div/div[2]/div[2]/button/span")));
    }

    @And("^clicks on Next button$")
    public void clicksOnNextButton() {
        personalDetailsPage.nextButtonClick();
    }

    @Then("^no cover is available$")
    public void noCoverIsAvailable() {
        Assert.assertTrue(base.Driver.getPageSource().contains("We aren’t able to offer cover to people with pre-existing medical conditions. We’re working hard to change this."));
        base.Driver.close();
    }
}
