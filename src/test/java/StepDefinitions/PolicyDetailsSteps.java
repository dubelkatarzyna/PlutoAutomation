package StepDefinitions;

import Base.BaseUtil;
import Pages.PolicyDetailsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PolicyDetailsSteps extends BaseUtil {

    private BaseUtil base;
    private PolicyDetailsPage policyDetailsPage = new PolicyDetailsPage(base.Driver);

    public PolicyDetailsSteps(BaseUtil base) {
        this.base = base;
    }

    @When("^a user click on email me this quote link$")
    public void aUserClickOnEmailMeThisQuoteLink() {
        policyDetailsPage.emailYourQuoteHyperlinkClick();
    }

    @Then("^quote reminder page is opened$")
    public void quoteReminderPageIsOpened() {
        Assert.assertTrue(base.Driver.getPageSource().contains("Email me my quote"));
    }
}
