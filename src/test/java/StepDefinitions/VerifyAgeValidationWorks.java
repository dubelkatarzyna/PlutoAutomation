package StepDefinitions;

import Base.BaseUtil;
import Pages.PersonalDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyAgeValidationWorks extends BaseUtil {

    private BaseUtil base;
    private PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(base.Driver);
    WebDriverWait wait = new WebDriverWait(base.Driver, 5);

    public VerifyAgeValidationWorks(BaseUtil base) {
        this.base = base;
    }

    @Given("^a web browser is on personal details page$")
    public void aWebBrowserIsOnPersonalDetailsPage() {
        base.Driver.navigate().to("https://pluto-customer-web-app-staging.herokuapp.com/personal-details-annual");
        Assert.assertTrue(base.Driver.getPageSource().contains("A bit about you"));
    }


    @Then("^Validation tooltip appears$")
    public void validationTooltipAppears() {
        Assert.assertTrue(base.Driver.findElement(By.xpath("//*[@id=\"age-helper-text\"]/span/span[2]")).isDisplayed());
        base.Driver.close();
    }

    @And("^selects no medical condition$")
    public void selectsNoMedicalCondition() {
        personalDetailsPage.selectPreExistingMedicalPreconditions();
    }

    @When("^a user provides age that is outside the range$")
    public void aUserProvidesAgeThatIsOutsideTheRange() {
        personalDetailsPage.typeAge("78");
        personalDetailsPage.usernameTextboxClick();
    }
}
